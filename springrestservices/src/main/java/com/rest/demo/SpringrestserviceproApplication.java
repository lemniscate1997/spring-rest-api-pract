package com.rest.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.rest")
@SpringBootApplication
public class SpringrestserviceproApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringrestserviceproApplication.class, args);
	}

}
