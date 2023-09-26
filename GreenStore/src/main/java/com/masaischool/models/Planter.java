package com.masaischool.models;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.masaischool.enums.Level;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
	
	private int planterStock;
	
	private Double planterCost;
	
	private Plant plant;
	
	private Seed seed;
	
	@JsonIgnore
	@ManyToMany(mappedBy="planters")
	private Set<Orders> orders;
	
	

}
