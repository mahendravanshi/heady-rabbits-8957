package com.masaischool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masaischool.models.Plant;

public interface PlantRepository extends JpaRepository<Plant, Integer> {

}
