package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CLRunner  implements CommandLineRunner {

	@Autowired
	private IUserDao dao;
	
	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Inside Commandline runner");
		dao.deleteAll().subscribe();
		
		dao.save(new User("Pratik")).subscribe();
		System.out.println("Commandline runner complete");
		
	}

}
