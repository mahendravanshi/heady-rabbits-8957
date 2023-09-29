package com.masaischool.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masaischool.models.Seed;
import com.masaischool.service.SeedService;

import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/admin/seed")
@Slf4j 
@CrossOrigin(origins="*")
public class SeedController {

    @Autowired
    private SeedService seedService;

    @PostMapping("/add")
    public ResponseEntity<Seed> addSeed(@RequestBody Seed seed) {
        log.info("Adding a new seed: {}", seed);
        Seed addedSeed = seedService.addSeed(seed);
        return new ResponseEntity<>(addedSeed, HttpStatus.CREATED);
    }

    
    @PutMapping("/{seedId}")
    public ResponseEntity<Seed> updateSeed(@PathVariable Integer seedId, @RequestBody Seed seed) {
        log.info("Updating seed with ID {}: {}", seedId, seed);
        Seed updatedSeed = seedService.updateSeed(seed, seedId);
        return new ResponseEntity<>(updatedSeed, HttpStatus.OK);
    }

    @DeleteMapping("/{seedId}")
    public ResponseEntity<Seed> deleteSeed(@PathVariable Integer seedId) {
        log.info("Deleting seed with ID: {}", seedId);
        Seed deletedSeed = seedService.deleteSeed(seedId);
        return new ResponseEntity<>(deletedSeed, HttpStatus.OK);
    }

    @GetMapping("/view/{seedId}")
    public ResponseEntity<Seed> viewSeed(@PathVariable Integer seedId) {
        log.info("Viewing seed by ID: {}", seedId);
        Seed seed = seedService.viewSeed(seedId);
        return new ResponseEntity<>(seed, HttpStatus.OK);
    }

    @GetMapping("/viewByName/{commonName}")
    public ResponseEntity<Seed> viewSeedByCommonName(@PathVariable String commonName) {
        log.info("Viewing seed by common name: {}", commonName);
        Seed seed = seedService.viewSeed(commonName);
        return new ResponseEntity<>(seed, HttpStatus.OK);
    }

    @GetMapping("/viewAll")
    public ResponseEntity<List<Seed>> viewAllSeeds(@RequestParam String fieldOne, @RequestParam String dirOne,
                                                   @RequestParam int pageNumber, @RequestParam int pageSize) {
        log.info("Viewing all seeds");
        List<Seed> seeds = seedService.viewAllSeeds(fieldOne, dirOne, pageNumber, pageSize);
        return new ResponseEntity<>(seeds, HttpStatus.OK);
    }
    
    @GetMapping("/viewByType")
    public ResponseEntity<List<Seed>> viewAllSeedsByType(@RequestParam String typeOfSeed,
                                                         @RequestParam String fieldOne, @RequestParam String dirOne,
                                                         @RequestParam int pageNumber, @RequestParam int pageSize) {
        log.info("Viewing seeds by type: {}", typeOfSeed);
        List<Seed> seeds = seedService.viewAllSeedsByType(typeOfSeed, fieldOne, dirOne, pageNumber, pageSize);
        return new ResponseEntity<>(seeds, HttpStatus.OK);
    }
}