package edu.inconcept.netflix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class NetflixApplication  {

	public static void main(String[] args) {
		SpringApplication.run(NetflixApplication.class, args);
	}
}
