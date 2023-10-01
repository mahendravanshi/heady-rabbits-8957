package com.masaischool.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masaischool.models.Address;
import com.masaischool.models.Customer;
import com.masaischool.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins="*")
public class CustomerController {
	
//	@Autowired
	private CustomerService customerService;
//	private PasswordEncoder passwordEncoder;
	
	
//   @Autowired
//	public CustomerController(CustomerService customerService, PasswordEncoder passwordEncoder) {
//		
//		this.customerService = customerService;
//		this.passwordEncoder = passwordEncoder;
//	}



	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	

	
    
	@PostMapping("/customers")
	public ResponseEntity<Customer> registerCustomer(@Valid @RequestBody Customer customer){
		
		System.out.println(customer);
		List<Address> addresses = customer.getAddresses();
		System.out.println(addresses);
		for(Address address : addresses) {
			address.setCustomer(customer);
			
		}
		
		System.out.println(customer.getPassword());
//		String encodePasswordString = passwordEncoder.encode(customer.getPassword());
//		customer.setPassword(encodePasswordString);
		return new ResponseEntity<Customer>(customerService.registerCustomer(customer), HttpStatus.CREATED);
		
	}
	
	
	
}
