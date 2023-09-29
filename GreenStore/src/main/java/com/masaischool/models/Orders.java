package com.masaischool.models;

import java.time.LocalDate;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
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
public class Orders {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderId;
	
	@CreationTimestamp
	private LocalDate orderDate;
	
	
	private String transactionMode;
	
	
	private int quantity;
	
	
	private Double totalCost;
	
	@JsonIgnore
	@ManyToMany
    @JoinTable(
        name = "order_planter",
        joinColumns = @JoinColumn(name = "order_id"),
        inverseJoinColumns = @JoinColumn(name = "planter_id")
    )
	
    private Set<Planter> planters;
	
	
	@JsonIgnore
	@ManyToMany
    @JoinTable(
        name = "order_plant",
        joinColumns = @JoinColumn(name = "order_id"),
        inverseJoinColumns = @JoinColumn(name = "plant_id")
    )
    private Set<Plant> plants;
	
	@JsonIgnore
	@ManyToMany
    @JoinTable(
        name = "order_seed",
        joinColumns = @JoinColumn(name = "order_id"),
        inverseJoinColumns = @JoinColumn(name = "seed_id")
    )
	
    private Set<Seed> seeds;
	
	
	
	
	
}
