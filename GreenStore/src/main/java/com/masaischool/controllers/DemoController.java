package com.masaischool.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins="*")

public class DemoController {

	
	
	
	
	@GetMapping("/hello")
	public ResponseEntity<String> welcomeHello(){
		
		return new ResponseEntity<>("We are inside hello authenticated",HttpStatus.OK);
	}
	
	@GetMapping("/helloAgain")
	public ResponseEntity<String> helloAgain(){
		
		return new ResponseEntity<>("We are inside hello again authenticated",HttpStatus.OK);
	}
	
	@GetMapping("/admin")
	public ResponseEntity<String> helloAdmin(){
		
		return new ResponseEntity<>("Only admin role can open this",HttpStatus.OK);
	}
	

	@GetMapping("/user")
	public ResponseEntity<String> helloUser(){
		
		return new ResponseEntity<>("Only user role can open this",HttpStatus.OK);
	}
	
	
	
	
	
	
}
