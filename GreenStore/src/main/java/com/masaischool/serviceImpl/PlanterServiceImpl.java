package com.masaischool.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.masaischool.exceptions.PlanterNotFoundException;
import com.masaischool.models.Planter;
import com.masaischool.repository.PlanterRepository;
import com.masaischool.service.PlanterService;

@Service
public class PlanterServiceImpl implements PlanterService {

	
	@Autowired
	private PlanterRepository planterRepository;

	@Override
	public Planter addPlanter(Planter planter) {
		
		   planterRepository.save(planter);
		   
		   return planter;
	}
	
	public Planter getById(Integer planterId) {
		
		Planter planter = planterRepository
			    .findById(planterId)
			    .filter(Planter::isPresent) // Only consider present planters
			    .orElseThrow(() -> new PlanterNotFoundException("Planter not found with planter id " + planterId));
		  
		  return planter;
	}

	@Override
	public Planter updatePlanter(Planter planter, Integer planterId) {
		
		    Planter p = getById(planterId);
		    
		    p.setDrainageHoles(planter.getDrainageHoles());
		    p.setPlanterCapacity(planter.getPlanterCapacity());
		    p.setPlanterColor(planter.getPlanterColor());
		    p.setPlanterCost(planter.getPlanterCost());
		    p.setPlanterStock(planter.getPlanterStock());
		    
		    planterRepository.save(p);
		    
		    return p;
	}

	@Override
	public Planter deletePlanter(Integer planterId) {
		
		  Planter planter = getById(planterId);
		  
		  if(!planter.isPresent()) {
			  throw new PlanterNotFoundException("Planter is not present with planterId "+planterId);
		  }
		  
		  planter.setPresent(false);
		  
		  return planter;
	}

	@Override
	public Planter viewPlanter(Integer planterId) {
		
		Planter planter  = getById(planterId);
		
		return planter;
	}

	
	@Override
	public Planter viewPlanter(String commonName) {
		
		   Planter planter = planterRepository.viewPlanter(commonName);
		   if(planter==null) {
			   throw new PlanterNotFoundException("Planter is not found with commonName "+commonName);
		   }
		   
		   return planter;
		   
	}
	@Override
	public List<Planter> viewAllPlanters(String fieldOne, String dirOne, int pageNumber, int pageSize) {
	    Sort sort = dirOne.equalsIgnoreCase("asc") ? Sort.by(Sort.Direction.ASC, fieldOne) : Sort.by(Sort.Direction.DESC, fieldOne);
	    Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, sort);

	    Page<Planter> page = planterRepository.findByIsPresentTrue(pageable);

	    
	    if(page.hasContent()) {
	    	return page.getContent();
	    }
	   
	    throw new PlanterNotFoundException("Planter is not found, the list is empty");
	    

	}


	@Override
	public List<Planter> viewAllPlantersByType(String typeOfPlanter,String fieldOne,String dirOne,int pageNumber,int pageSize) {
		
		Sort sort = dirOne.equalsIgnoreCase("asc") ? Sort.by(Sort.Direction.ASC, fieldOne) : Sort.by(Sort.Direction.DESC, fieldOne);
	    Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, sort);

	    Page<Planter> page = planterRepository.findByTypeOfPlanterandIsPresentTrue(typeOfPlanter, pageable);

	    
	    if(page.hasContent()) {
	    	return page.getContent();
	    }
		
			throw new PlanterNotFoundException("Planter is not found  by plant type "+typeOfPlanter);
	     
	}
	  
	  
}
