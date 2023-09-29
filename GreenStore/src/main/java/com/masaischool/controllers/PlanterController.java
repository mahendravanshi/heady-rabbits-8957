package com.masaischool.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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

import com.masaischool.models.Planter;
import com.masaischool.service.PlanterService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/admin/planter")
@Slf4j 
@CrossOrigin(origins="*")

public class PlanterController {

    @Autowired
    private PlanterService planterService;
   
    @PostMapping("/add")
    public ResponseEntity<Planter> addPlanter(@RequestBody Planter planter) {
        log.info("Adding a new planter: {}", planter);
        Planter addedPlanter = planterService.addPlanter(planter);
        return new ResponseEntity<>(addedPlanter, HttpStatus.CREATED);
    }

    @PutMapping("/{planterId}")
    public ResponseEntity<Planter> updatePlanter(@PathVariable Integer planterId, @RequestBody Planter planter) {
        log.info("Updating planter with ID {}: {}", planterId, planter);
        Planter updatedPlanter = planterService.updatePlanter(planter, planterId);
        return new ResponseEntity<>(updatedPlanter, HttpStatus.OK);
    }

    @DeleteMapping("/{planterId}")
    public ResponseEntity<Planter> deletePlanter(@PathVariable Integer planterId) {
        log.info("Deleting planter with ID: {}", planterId);
        Planter deletedPlanter = planterService.deletePlanter(planterId);
        return new ResponseEntity<>(deletedPlanter, HttpStatus.OK);
    }

    @GetMapping("/view/{planterId}")
    public ResponseEntity<Planter> viewPlanter(@PathVariable Integer planterId) {
        log.info("Viewing planter by ID: {}", planterId);
        Planter planter = planterService.viewPlanter(planterId);
        return new ResponseEntity<>(planter, HttpStatus.OK);
    }

    @GetMapping("/viewByName/{commonName}")
    public ResponseEntity<Planter> viewPlanterByCommonName(@PathVariable String commonName) {
        log.info("Viewing planter by common name: {}", commonName);
        Planter planter = planterService.viewPlanter(commonName);
        return new ResponseEntity<>(planter, HttpStatus.OK);
    }

    @GetMapping("/viewAll")
    public ResponseEntity<List<Planter>> viewAllPlanters(@RequestParam String fieldOne, @RequestParam String dirOne,
                                                        @RequestParam int pageNumber, @RequestParam int pageSize) {
        log.info("Viewing all planters");
        List<Planter> planters = planterService.viewAllPlanters(fieldOne, dirOne, pageNumber, pageSize);
        return new ResponseEntity<>(planters, HttpStatus.OK);
    }
    
    @GetMapping("/viewByType")
    public ResponseEntity<List<Planter>> viewAllPlantersByType(@RequestParam String typeOfPlanter,
                                                              @RequestParam String fieldOne, @RequestParam String dirOne,
                                                              @RequestParam int pageNumber, @RequestParam int pageSize) {
        log.info("Viewing planters by type: {}", typeOfPlanter);
        List<Planter> planters = planterService.viewAllPlantersByType(typeOfPlanter, fieldOne, dirOne, pageNumber, pageSize);
        return new ResponseEntity<>(planters, HttpStatus.OK);
    }
}