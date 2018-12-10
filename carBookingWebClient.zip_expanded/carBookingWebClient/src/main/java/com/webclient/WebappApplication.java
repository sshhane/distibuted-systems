package com.webclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class WebappApplication extends org.springframework.boot.web.servlet.support.SpringBootServletInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(WebappApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(WebappApplication.class, args);
	}
}
