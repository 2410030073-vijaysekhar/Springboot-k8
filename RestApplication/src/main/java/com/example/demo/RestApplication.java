package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@SpringBootApplication
public class RestApplication {
	@GetMapping("/cse")
	public String cse() {
		return "welcome to cse";
		
	}
	@GetMapping("/ece")
	public String ece() {
		return "welcome to ECE dept";
		
	}
	public static void main(String[] args) {
		SpringApplication.run(RestApplication.class, args);
	}

}
