package com.masaischool.models;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Planter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer planterId;
	
	
	private Double planterHeight;
	
	private Double planterCapacity;
	
	private int drainageHoles;
	
	private String planterColor;
	
	
	private String planterShape;
	
	@Min(value = 0, message = "Planter stock should be greater than or equal to zero")
	private int planterStock;
	
	@Min(value=0,message="planterCost cannot be less than zero")
	private Double planterCost;
	
	private boolean isPresent;
	
	
	private Plant plant;
	
	private Seed seed;
	
	@JsonIgnore
	@ManyToMany(mappedBy="planters")
	private Set<Orders> orders;
	
	

}
