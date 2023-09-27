package com.masaischool.models;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RolesAndAuthority {

	
	private Integer roleId;
	
	private String roleName;
	
	@ManyToMany(mappedBy="rolesAndAuthorities")
	private Set<Customer> customers;
	
	
	
}
