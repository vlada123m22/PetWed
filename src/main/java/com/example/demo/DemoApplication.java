package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



//TODO (FOR DISPLAYING PAST MESSAGES)
//1. SELECT DISTINCT user_to_id FROM Messages WHERE user_from_id=authenticated (and display those users whet the authenticated user clicks on messages)



@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
	}

}
