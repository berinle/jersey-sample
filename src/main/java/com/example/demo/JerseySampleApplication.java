package com.example.demo;

import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class JerseySampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(JerseySampleApplication.class, args);
	}

	@Component
	class JerseyConfig extends ResourceConfig {
		public JerseyConfig() {
			register(MultiPartFeature.class);
			register(UploadEndpoint.class);
		}
	}

}
