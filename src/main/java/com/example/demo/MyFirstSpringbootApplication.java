package com.example.demo;
import com.example.demo.user.Character;

import com.example.demo.mongo.GdataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class MyFirstSpringbootApplication implements CommandLineRunner {

	@Autowired
	GdataRepository g_repo;

	public static void main(String[] args) {

		SpringApplication.run(MyFirstSpringbootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		g_repo.deleteAll();
		g_repo.save(new Character());
		System.out.println();
		for (Character character : g_repo.findAll()){

		}
	}

}
