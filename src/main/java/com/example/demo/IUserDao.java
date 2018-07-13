package com.example.demo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface IUserDao extends ReactiveMongoRepository<User, String> {

}
