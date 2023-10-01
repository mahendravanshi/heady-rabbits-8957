package com.masaischool.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.masaischool.exceptions.PlantNotFoundException;
import com.masaischool.models.Plant;
import com.masaischool.repository.PlantRepository;
import com.masaischool.service.PlantService;


@Service
public class PlantServiceImpl implements PlantService {

	   @Autowired
	   private PlantRepository plantRepository;
	  

		@Override
		public Plant addPlant(Plant plant) {
			
			   plantRepository.save(plant);
			   
			   return plant;
		}
		
		public Plant getById(Integer plantId) {
			
			Plant Plant = plantRepository
				    .findById(plantId)
				    .filter(x->x.isPresent()) // Only consider present Plants
				    .orElseThrow(() -> new PlantNotFoundException("Plant not found with plant id " +plantId));
			        
			  return Plant;
		}

		@Override
		public Plant updatePlant(Plant plant, Integer plantId) {
			
			    Plant p = getById(plantId);
			    
			  
			     plant.setPlantId(plantId);
			    
			    plantRepository.save(plant);
			    
			    return plant;
		}
       
		@Override
		public Plant deletePlant(Integer plantId) {
			
			  Plant plant = getById(plantId);
			  
			  if(!plant.isPresent()) {
				  throw new PlantNotFoundException("Plant is not present with PlantId "+plantId);
			  }
			  
			  plant.setPresent(false);
			  
			  return plant;
		}

		@Override
		public Plant viewPlant(Integer plantId) {
			
			Plant plant  = getById(plantId);
			
			return plant;
		}

		
		@Override
		public Plant viewPlant(String commonName) {
			
			   Plant plant = plantRepository.viewPlant(commonName);
			   if(plant==null) {
				   throw new PlantNotFoundException("Plant is not found with commonName "+commonName);
			   }
			   
			   return plant;
			   
		}
		
		
		@Override
		public List<Plant> viewAllPlants(String fieldOne, String dirOne, int pageNumber, int pageSize) {
		    Sort sort = dirOne.equalsIgnoreCase("asc") ? Sort.by(Sort.Direction.ASC, fieldOne) : Sort.by(Sort.Direction.DESC, fieldOne);
		    Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, sort);

		    Page<Plant> page = plantRepository.findByIsPresentTrue(pageable);

		    
		    if(page.hasContent()) {
		    	return page.getContent();
		    }
		   
		    throw new PlantNotFoundException("Plant is not found, the list is empty");
		    

		}


		@Override
		public List<Plant> viewAllPlantsByType(String typeOfPlant,String fieldOne,String dirOne,int pageNumber,int pageSize) {
			
			Sort sort = dirOne.equalsIgnoreCase("asc") ? Sort.by(Sort.Direction.ASC, fieldOne) : Sort.by(Sort.Direction.DESC, fieldOne);
		    Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, sort);

		    Page<Plant> page = plantRepository.findByTypeOfPlantAndIsPresentTrue(typeOfPlant, pageable);

		    
		    if(page.hasContent()) {
		    	return page.getContent();
		    }
			
				throw new PlantNotFoundException("Plant is not found  by plant type "+typeOfPlant);
		     
		}
}
