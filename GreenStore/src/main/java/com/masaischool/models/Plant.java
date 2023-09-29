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
public class Plant {
	
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer plantId;
	
	private Double plantHeight;
	
	@NotBlank(message="plantSpread required")
	private String plantSpread;
	
	@NotBlank(message="bloomTime required")
	private String bloomTime;
	
	@NotBlank(message="plantType required")
	private String plantType;
	
	@NotBlank(message="Common name required")
	private String commonName;
	
	@NotBlank(message="username required")
	@Enumerated(EnumType.STRING)
	private Level difficultyLevel;
	
	private Double temperature;
	
	@NotBlank(message="typeOfPlant required")
	private String typeOfPlant;
	
	@NotBlank(message="plantDescription required")
	private String plantDescription;
	
	@Min(value=1L)
	private Integer stock;
	
	@Min(value=1L)
	private int quantity;
	
	
	private boolean isPresent;
	
	@Min(value=1L,message="Enter correct price")
	private Double plantCost;
	
	@JsonIgnore
	@ManyToMany(mappedBy="plants")
	private Set<Orders> orders;
	
	
	
	
	
}
