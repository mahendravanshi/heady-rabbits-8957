package com.masaischool.service;

import java.util.List;

import com.masaischool.models.Plant;
import com.masaischool.models.Planter;



public interface PlantService {
   
	
	   public Plant addPlant(Plant Plant);
	   public Plant updatePlant(Plant Plant,Integer PlantId);
	   public Plant deletePlant(Integer PlantId);
	   public Plant viewPlant(Integer PlantId);
	   public Plant viewPlant(String commonName);
	   public List<Plant> viewAllPlants(String fieldOne,String dirOne,int pageNumber,int pageSize);
	   public List<Plant> viewAllPlantsByType(String typeOfPlant,String fieldOne,String dirOne,int pageNumber,int pageSize);
	   
}
