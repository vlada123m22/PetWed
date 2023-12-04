package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


//TODO (FOR DISPLAYING PAST MESSAGES)
//1. SELECT DISTINCT user_to_id FROM Messages WHERE user_from_id=authenticated (and display those users whet the authenticated user clicks on messages)



@SpringBootApplication
public class DemoApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
	}

}
