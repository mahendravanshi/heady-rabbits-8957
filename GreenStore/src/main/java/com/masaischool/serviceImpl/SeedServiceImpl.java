package com.masaischool.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.masaischool.exceptions.SeedNotFoundException;
import com.masaischool.models.Seed;
import com.masaischool.repository.SeedRepository;
import com.masaischool.service.SeedService;


@Service
public class SeedServiceImpl implements SeedService {

	
	@Autowired
	private SeedRepository seedRepository;

	@Override
	public Seed addSeed(Seed seed) {
		
		   seedRepository.save(seed);
		   
		   return seed;
	}
	
	public Seed getById(Integer seedId) {
		
		Seed seed = seedRepository
			    .findById(seedId)
			    .filter(Seed::isPresent) // Only consider present Seeds
			    .orElseThrow(() -> new SeedNotFoundException("Seed not found with Seed id " + seedId));
		  
		  return seed;
	}

	@Override
	public Seed updateSeed(Seed seed, Integer seedId) {
		
		    Seed s = getById(seedId);
		    
		    seed.setSeedId(s.getSeedId());
		    
		    
		    return seed;
	}

	@Override
	public Seed deleteSeed(Integer seedId) {
		
		  Seed seed = getById(seedId);
		  
		  if(!seed.isPresent()) {
			  throw new SeedNotFoundException("Seed is not present with seedId "+seedId);
		  }
		  
		  seed.setPresent(false);
		  
		  return seed;
	}

	@Override
	public Seed viewSeed(Integer seedId) {
		
		Seed seed  = getById(seedId);
		
		return seed;
	}

	
	@Override
	public Seed viewSeed(String commonName) {
		
		   Seed seed = seedRepository.viewSeed(commonName);
		   if(seed==null) {
			   throw new SeedNotFoundException("Seed is not found with commonName "+commonName);
		   }
		   
		   return seed;
		   
	}
	@Override
	public List<Seed> viewAllSeeds(String fieldOne, String dirOne, int pageNumber, int pageSize) {
	    Sort sort = dirOne.equalsIgnoreCase("asc") ? Sort.by(Sort.Direction.ASC, fieldOne) : Sort.by(Sort.Direction.DESC, fieldOne);
	    Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, sort);

	    Page<Seed> page = seedRepository.findByIsPresentTrue(pageable);

	    
	    if(page.hasContent()) {
	    	return page.getContent();
	    }
	   
	    throw new SeedNotFoundException("Seed is not found, the list is empty");
	    

	}


	@Override
	public List<Seed> viewAllSeedsByType(String typeOfSeed,String fieldOne,String dirOne,int pageNumber,int pageSize) {
		
		Sort sort = dirOne.equalsIgnoreCase("asc") ? Sort.by(Sort.Direction.ASC, fieldOne) : Sort.by(Sort.Direction.DESC, fieldOne);
	    Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, sort);

	    Page<Seed> page = seedRepository.findByTypeOfSeedAndIsPresentTrue(typeOfSeed, pageable);

	    
	    if(page.hasContent()) {
	    	return page.getContent();
	    }
		
			throw new SeedNotFoundException("Seed is not found  by plant type "+typeOfSeed);
	     
	}
	  
	
	
}
