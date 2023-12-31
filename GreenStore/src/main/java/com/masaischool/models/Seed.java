package com.masaischool.models;



import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.masaischool.enums.Level;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class Seed {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer seedId;
	
	@NotBlank(message="commonName required")
	private String commonName;
	
	@NotBlank(message="bloomTime required")
	private String bloomTime;
	
	@NotBlank(message="watering required")
	private  String watering;
	
	@Enumerated(EnumType.STRING)
	private Level level;
	
    private Double temperature;
	
	@NotBlank(message="typeOfSeed required")
	private String typeOfSeed;
	
	@NotBlank(message="plantDescription required")
	private String seedDescription;
	
	@Min(value=1L)
	private Integer stock;
	
	@Min(value=1L)
	private int quantity;
	
	@Min(value=1L,message="Enter correct price")
	private Double seedCost;
	
	@Min(value=1L,message="Enter correct seedsPerPacket min is 1")
	private int seedsPerPacket;
	
	private boolean isPresent;
	
	@JsonIgnore
	@ManyToMany(mappedBy="seeds")
	private Set<Orders> orders;
	
	
	
}
