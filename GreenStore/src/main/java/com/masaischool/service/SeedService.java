package com.masaischool.service;

import java.util.List;

import com.masaischool.models.Seed;

public interface SeedService {

	
	   public Seed addSeed(Seed seed);
	   public Seed updateSeed(Seed seed,Integer seedId);
	   public Seed deleteSeed(Integer seedId);
	   public Seed viewSeed(Integer seedId);
	   public Seed viewSeed(String commonName);
	   public List<Seed> viewAllSeeds();
	   public List<Seed> viewAllSeedsByType(String typeOfSeed);
	   
	   
}
