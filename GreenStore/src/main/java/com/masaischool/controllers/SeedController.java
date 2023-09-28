package com.masaischool.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.masaischool.models.Seed;
import com.masaischool.service.SeedService;

import java.util.List;

@Controller
@RequestMapping("/admin/seed")
public class SeedController {

	@Autowired
	private SeedService seedService;

	@PostMapping("/add")
	public ResponseEntity<Seed> addSeed(@RequestBody Seed seed) {
		Seed addedSeed = seedService.addSeed(seed);
		return new ResponseEntity<>(addedSeed, HttpStatus.CREATED);
	}

	@PutMapping("/{seedId}")
	public ResponseEntity<Seed> updateSeed(@PathVariable Integer seedId, @RequestBody Seed seed) {
		Seed updatedSeed = seedService.updateSeed(seed, seedId);
		return new ResponseEntity<>(updatedSeed, HttpStatus.OK);
	}

	@DeleteMapping("/{seedId}")
	public ResponseEntity<Seed> deleteSeed(@PathVariable Integer seedId) {
		Seed deletedSeed = seedService.deleteSeed(seedId);
		return new ResponseEntity<>(deletedSeed, HttpStatus.OK);
	}

	@GetMapping("/view/{seedId}")
	public ResponseEntity<Seed> viewSeed(@PathVariable Integer seedId) {
		Seed seed = seedService.viewSeed(seedId);
		return new ResponseEntity<>(seed, HttpStatus.OK);
	}

	@GetMapping("/viewByName/{commonName}")
	public ResponseEntity<Seed> viewSeedByCommonName(@PathVariable String commonName) {
		Seed seed = seedService.viewSeed(commonName);
		return new ResponseEntity<>(seed, HttpStatus.OK);
	}

	@GetMapping("/viewAll")
	public ResponseEntity<List<Seed>> viewAllSeeds(@RequestParam String fieldOne, @RequestParam String dirOne,
			@RequestParam int pageNumber, @RequestParam int pageSize) {
		List<Seed> seeds = seedService.viewAllSeeds(fieldOne, dirOne, pageNumber, pageSize);
		return new ResponseEntity<>(seeds, HttpStatus.OK);
	}

	@GetMapping("/viewByType")
	public ResponseEntity<List<Seed>> viewAllSeedsByType(@RequestParam String typeOfSeed, @RequestParam String fieldOne,
			@RequestParam String dirOne, @RequestParam int pageNumber, @RequestParam int pageSize) {
		List<Seed> seeds = seedService.viewAllSeedsByType(typeOfSeed, fieldOne, dirOne, pageNumber, pageSize);
		return new ResponseEntity<>(seeds, HttpStatus.OK);
	}
}
