package com.example.demo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info=@Info(title="Students Controller",version="1.0",description="Students Management "))
public class CrudOpeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudOpeApplication.class, args);
	}

}
