package com.example.java_spring_ddd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport(pageSerializationMode = EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO)
public class JavaSpringDddApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaSpringDddApplication.class, args);
	}

}
