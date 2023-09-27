package com.masaischool.service;

import java.util.List;

import com.masaischool.models.Planter;

public interface PlanterService {
  
	   public Planter addPlanter(Planter planter);
	   public Planter updatePlanter(Planter planter,Integer planterId);
	   public Planter deletePlanter(Integer planterId);
	   public Planter viewPlanter(Integer planterId);
	   public Planter viewPlanter(String commonName);
	   public List<Planter> viewAllPlanters();
	   public List<Planter> viewAllPlantersByType(String typeOfPlanter);
	   
}
