package com.masaischool.models;

import java.util.List;
import java.util.Set;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(force=true)
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;

//	@NotBlank(message = "name required")
	@Size(min = 3, max = 50, message = "name should be greater than two and less than 50")
	
	private String customerName;

	@Column(name = "email", unique = true, nullable = false)
//	@NotBlank(message = "email required")
	@Email
	private String email;

	@Column(name = "username", unique = true, nullable = false)
//	@NotBlank(message = "username required")
	private String username;

	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "customer_role", joinColumns = @JoinColumn(referencedColumnName = "customerId", name = "customer_id"), inverseJoinColumns = @JoinColumn(referencedColumnName = "roleId", name = "role_id"))
    private Set<RolesAndAuthority> rolesAndAuthorities;

	@JsonProperty(access = Access.WRITE_ONLY)
	@Size(min = 5, max = 500, message = "password size should be between 5 and 50")
	
	private String password;

//	@JsonIgnore
	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JsonProperty(value="addresses")
    private List<Address> addresses;

	public Customer(
			@NotBlank(message = "name required") @Size(min = 3, max = 50, message = "name should be greater than two and lessthan 50") String customerName,
			@NotBlank(message = "email required") @Email String email,
			@NotBlank(message = "username required") String username, Set<RolesAndAuthority> rolesAndAuthorities,
			@Size(min = 5, max = 500, message = "password size should be between 5 and 50") String password,
			List<Address> addresses) {
		super();
		this.customerName = customerName;
		this.email = email;
		this.username = username;
		this.rolesAndAuthorities = rolesAndAuthorities;
		this.password = password;
		this.addresses = addresses;
	}
	
	
   
	

}
