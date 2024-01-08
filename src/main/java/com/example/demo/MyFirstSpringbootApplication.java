package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication
@EnableMongoRepositories
public class MyFirstSpringbootApplication extends SpringBootServletInitializer { // implements CommandLineRunner

	public static void main(String[] args) {

		SpringApplication.run(MyFirstSpringbootApplication.class, args);
	}
}
