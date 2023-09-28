package com.masaischool.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.masaischool.models.Plant;
import com.masaischool.service.PlantService;

import java.util.List;

@Controller
@RequestMapping("/admin/plant")
public class PlantController {

	@Autowired
	private PlantService plantService;


	@PostMapping("/add")
	public ResponseEntity<Plant> addPlant(@RequestBody Plant plant) {
		Plant addedPlant = plantService.addPlant(plant);
		return new ResponseEntity<>(addedPlant, HttpStatus.CREATED);
	}

	@PutMapping("/{plantId}")
	public ResponseEntity<Plant> updatePlant(@PathVariable Integer plantId, @RequestBody Plant plant) {
		Plant updatedPlant = plantService.updatePlant(plant, plantId);
		return new ResponseEntity<>(updatedPlant, HttpStatus.OK);
	}

	@DeleteMapping("/{plantId}")
	public ResponseEntity<Plant> deletePlant(@PathVariable Integer plantId) {
		Plant deletedPlant = plantService.deletePlant(plantId);
		return new ResponseEntity<>(deletedPlant, HttpStatus.OK);
	}

	@GetMapping("/view/{plantId}")
	public ResponseEntity<Plant> viewPlant(@PathVariable Integer plantId) {
		Plant plant = plantService.viewPlant(plantId);
		return new ResponseEntity<>(plant, HttpStatus.OK);
	}

	@GetMapping("/viewByName/{commonName}")
	public ResponseEntity<Plant> viewPlantByCommonName(@PathVariable String commonName) {
		Plant plant = plantService.viewPlant(commonName);
		return new ResponseEntity<>(plant, HttpStatus.OK);
	}

	@GetMapping("/viewAll")
	public ResponseEntity<List<Plant>> viewAllPlants(@RequestParam String fieldOne, @RequestParam String dirOne,
			@RequestParam int pageNumber, @RequestParam int pageSize) {
		List<Plant> plants = plantService.viewAllPlants(fieldOne, dirOne, pageNumber, pageSize);
		return new ResponseEntity<>(plants, HttpStatus.OK);
	}

	@GetMapping("/viewByType")
	public ResponseEntity<List<Plant>> viewAllPlantsByType(@RequestParam String typeOfPlant,
			@RequestParam String fieldOne, @RequestParam String dirOne, @RequestParam int pageNumber,
			@RequestParam int pageSize) {
		List<Plant> plants = plantService.viewAllPlantsByType(typeOfPlant, fieldOne, dirOne, pageNumber, pageSize);
		return new ResponseEntity<>(plants, HttpStatus.OK);
	}
	
	
}
