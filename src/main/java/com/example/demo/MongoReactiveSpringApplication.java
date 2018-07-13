package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class MongoReactiveSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoReactiveSpringApplication.class, args);
	}
}
