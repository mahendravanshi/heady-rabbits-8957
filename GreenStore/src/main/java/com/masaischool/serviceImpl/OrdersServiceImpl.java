package com.masaischool.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.masaischool.repository.OrdersRepository;
import com.masaischool.service.OrdersService;

public class OrdersServiceImpl implements OrdersService {

	
	@Autowired
	private OrdersRepository ordersRepository;
	
	
}
