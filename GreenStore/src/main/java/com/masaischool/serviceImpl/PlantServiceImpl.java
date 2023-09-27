package com.masaischool.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masaischool.repository.PlantRepository;
import com.masaischool.service.PlantService;


@Service
public class PlantServiceImpl implements PlantService {

	   @Autowired
	   private PlantRepository plantrepository;
}
