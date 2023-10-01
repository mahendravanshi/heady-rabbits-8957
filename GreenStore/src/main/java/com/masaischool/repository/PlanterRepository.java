package com.masaischool.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.masaischool.models.Planter;

public interface PlanterRepository extends JpaRepository<Planter, Integer> {
 
	  @Query("select p from Planter p where p.commonName = :commonName")
	   public Planter viewPlanter(String commonName);
	  
	  
	  public Page<Planter> findByPlanterShapeAndIsPresentTrue(String typeOfPlanter,Pageable pageable);

	  public Page<Planter> findByIsPresentTrue(Pageable pageable);


    	  
	  
	  
}


