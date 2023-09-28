package com.masaischool.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masaischool.models.Plant;
import com.masaischool.service.PlantService;

import lombok.extern.slf4j.Slf4j; // Import Lombok's logging annotation

@RestController
@RequestMapping("/admin/plant")
@Slf4j // Add Lombok's logging annotation
public class PlantController {

	@Autowired
	private PlantService plantService;

	@PostMapping("/add")
	public ResponseEntity<Plant> addPlant(@RequestBody Plant plant) {
		log.info("Adding a new plant: {}", plant);
		Plant addedPlant = plantService.addPlant(plant);
		return new ResponseEntity<>(addedPlant, HttpStatus.CREATED);
	}

	@PutMapping("/{plantId}")
	public ResponseEntity<Plant> updatePlant(@PathVariable Integer plantId, @RequestBody Plant plant) {
		log.info("Updating plant with ID {}: {}", plantId, plant);
		Plant updatedPlant = plantService.updatePlant(plant, plantId);
		return new ResponseEntity<>(updatedPlant, HttpStatus.OK);
	}

	@DeleteMapping("/{plantId}")
	public ResponseEntity<Plant> deletePlant(@PathVariable Integer plantId) {
		log.info("Deleting plant with ID: {}", plantId);
		Plant deletedPlant = plantService.deletePlant(plantId);
		return new ResponseEntity<>(deletedPlant, HttpStatus.OK);
	}

	@GetMapping("/view/{plantId}")
	public ResponseEntity<Plant> viewPlant(@PathVariable Integer plantId) {
		log.info("Viewing plant by ID: {}", plantId);
		Plant plant = plantService.viewPlant(plantId);
		return new ResponseEntity<>(plant, HttpStatus.OK);
	}

	@GetMapping("/viewByName/{commonName}")
	public ResponseEntity<Plant> viewPlantByCommonName(@PathVariable String commonName) {
		log.info("Viewing plant by common name: {}", commonName);
		Plant plant = plantService.viewPlant(commonName);
		return new ResponseEntity<>(plant, HttpStatus.OK);
	}

	@GetMapping("/viewAll")
	public ResponseEntity<List<Plant>> viewAllPlants(@RequestParam String fieldOne, @RequestParam String dirOne,
			@RequestParam int pageNumber, @RequestParam int pageSize) {
		log.info("Viewing all plants");
		List<Plant> plants = plantService.viewAllPlants(fieldOne, dirOne, pageNumber, pageSize);
		return new ResponseEntity<>(plants, HttpStatus.OK);
	}

	@GetMapping("/viewByType")
	public ResponseEntity<List<Plant>> viewAllPlantsByType(@RequestParam String typeOfPlant,
			@RequestParam String fieldOne, @RequestParam String dirOne, @RequestParam int pageNumber,
			@RequestParam int pageSize) {
		log.info("Viewing plants by type: {}", typeOfPlant);
		List<Plant> plants = plantService.viewAllPlantsByType(typeOfPlant, fieldOne, dirOne, pageNumber, pageSize);
		return new ResponseEntity<>(plants, HttpStatus.OK);
	}
}
