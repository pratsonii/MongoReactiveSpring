package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/")
public class AppController 
{
	@Autowired
	IUserDao dao;
	
	@RequestMapping(value="stream", produces=MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<User> getUsers()
	{
		return dao.findAll();
	}
	
}
