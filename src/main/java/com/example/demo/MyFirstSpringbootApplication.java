package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class MyFirstSpringbootApplication { // implements CommandLineRunner

	public static void main(String[] args) {

		SpringApplication.run(MyFirstSpringbootApplication.class, args);
	}
}
