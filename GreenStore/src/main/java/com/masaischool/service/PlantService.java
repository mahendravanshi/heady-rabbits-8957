package com.masaischool.service;

import java.util.List;

import com.masaischool.models.Plant;
import com.masaischool.models.Planter;



public interface PlantService {
   
	
	   public Plant addPlant(Plant plant);
	   public Plant updatePlant(Plant plant,Integer plantId);
	   public Plant deletePlant(Integer plantId);
	   public Plant viewPlant(Integer plantId);
	   public Plant viewPlant(String commonName);
	   public List<Plant> viewAllPlants();
	   public List<Plant> viewAllPlantsByType(String typeOfPlant);
	   
}
