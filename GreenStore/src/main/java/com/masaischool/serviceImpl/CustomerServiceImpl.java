package com.masaischool.serviceImpl;

import org.springframework.stereotype.Service;

import com.masaischool.models.Customer;
import com.masaischool.repository.CustomerRepository;
import com.masaischool.service.CustomerService;


@Service
public class CustomerServiceImpl implements CustomerService {

	
	private CustomerRepository  customerRepository;
	
	
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}



	@Override
	public Customer registerCustomer(Customer customer) {
		
		return customerRepository.save(customer);
	}
	
	
	
	
	
	
}
