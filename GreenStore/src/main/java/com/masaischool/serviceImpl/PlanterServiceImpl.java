package com.masaischool.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masaischool.repository.PlanterRepository;
import com.masaischool.service.PlanterService;

@Service
public class PlanterServiceImpl implements PlanterService {

	
	  @Autowired
	  private PlanterRepository planterRepository;
	  
	  
}
