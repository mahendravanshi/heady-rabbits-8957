package com.masaischool.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masaischool.models.Seed;

public interface SeedRepository extends JpaRepository<Seed, Integer> {

	
	@Query("select s from Seed s where s.commonName = :commonName")
	public Seed viewSeed(String commonName);

	public Page<Seed> findByTypeOfSeedAndIsPresentTrue(String typeOfSeed, Pageable pageable);

	public Page<Seed> findByIsPresentTrue(Pageable pageable);
	    
	
}
