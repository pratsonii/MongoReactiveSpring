package com.example.demo;

import java.util.stream.IntStream;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/")
public class AppController 
{
	@Autowired
	IUserDao dao;
	
	int i = 0;
	
	private static org.slf4j.Logger logger = LoggerFactory.getLogger(AppController.class);
	
	@RequestMapping(value="stream", produces=MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<User> getUsers()
	{
		logger.info("log "+ i);
		return dao.findAll();
	}
	
	
	
	@GetMapping("test")
	public void getString()
	{
		IntStream.range(1, 10000).forEach( x -> {
		
			System.out.println(x);
			if(x < 5000 )
			{
				dao.save(new User("PRD" + x)).subscribe();
			}
			else
			{
				dao.save(new User("PRD" + x));
			}
		});	
	}
	
}
