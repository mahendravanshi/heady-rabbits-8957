package com.masaischool.models;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
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
	
	
	@Min(value=1L,message="The planter height should be greater than 0")
	private Double planterHeight;
	
	@Min(value=1L,message="The planterCapacity be greater than 0")
	private Double planterCapacity;
	
	@Min(value=1L,message="At least there should be one drainage Holes")
	private int drainageHoles;
	
	@NotBlank(message="planterColor required")
	private String planterColor;
	
	@NotBlank(message="Common name required")
	private String commonName;
	
	private String planterShape;
	
	@Min(value = 0, message = "Planter stock should be greater than or equal to zero")
	private int planterStock;
	
	@Min(value=0,message="planterCost cannot be less than zero")
	private Double planterCost;
	
	@Getter @Setter
	private boolean isPresent;
	
	
	private Plant plant;
	
	private Seed seed;
	
	@JsonIgnore
	@ManyToMany(mappedBy="planters")
	private Set<Orders> orders;
	
	

}
