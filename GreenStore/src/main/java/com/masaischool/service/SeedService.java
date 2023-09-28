package com.masaischool.service;

import java.util.List;

import com.masaischool.models.Seed;

public interface SeedService {

	
	   public Seed addSeed(Seed seed);
	   public Seed updateSeed(Seed Seed,Integer seedId);
	   public Seed deleteSeed(Integer seedId);
	   public Seed viewSeed(Integer seedId);
	   public Seed viewSeed(String commonName);
	   public List<Seed> viewAllSeeds(String fieldOne,String dirOne,int pageNumber,int pageSize);
	   public List<Seed> viewAllSeedsByType(String typeOfSeed,String fieldOne,String dirOne,int pageNumber,int pageSize);
	   
	   
}
