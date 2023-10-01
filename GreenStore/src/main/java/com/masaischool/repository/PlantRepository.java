package com.masaischool.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masaischool.models.Plant;

public interface PlantRepository extends JpaRepository<Plant, Integer> {

	@Query("select p from Plant p where p.commonName = :commonName")
	public Plant viewPlant(String commonName);

	public Page<Plant> findByTypeOfPlantAndIsPresentTrue(String typeOfPlant, Pageable pageable);

	public Page<Plant> findByIsPresentTrue(Pageable pageable);

}
