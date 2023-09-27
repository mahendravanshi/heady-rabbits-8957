package com.masaischool.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masaischool.repository.SeedRepository;
import com.masaischool.service.SeedService;


@Service
public class SeedServiceImpl implements SeedService {

	
	@Autowired
	private SeedRepository seedRepository;
	
	
}
