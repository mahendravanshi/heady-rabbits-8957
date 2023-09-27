package com.masaischool.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masaischool.repository.CustomerRepository;
import com.masaischool.service.CustomerService;


@Service
public class CustomerServiceImpl implements CustomerService {

	
	@Autowired
	private CustomerRepository  customerRepository;
}
