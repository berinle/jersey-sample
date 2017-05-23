package com.example.demo;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.InputStream;

@Component
@Path("/upload")
public class UploadEndpoint {
  @GET
  public Response hello() {
    return Response.status(200).entity("hello").build();
  }

  @POST
  public Response poke(@FormParam("foo") String foo) {
    System.out.println("foo = " + foo);
    return Response.status(201).build();
  }


  @Consumes(MediaType.MULTIPART_FORM_DATA)
  @Produces("application/json")
  @POST
  @Path("/xo")
  public Response multiPart(@FormDataParam("file") InputStream inputStream,
                            @FormDataParam("file") FormDataContentDisposition fileDetail) {
    System.out.println("inputStream = " + inputStream);
    System.out.println("fileDetail = " + fileDetail);

    return Response.status(200).build();
  }
}
