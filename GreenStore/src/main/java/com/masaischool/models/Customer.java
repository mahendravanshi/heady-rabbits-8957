package com.masaischool.models;

import java.util.Set;

import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails.Address;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	
	
	@NotBlank(message="Colony  required")
	@Size(min=3,max=50,message="name should be greater than two and lessthan 50")
	private String customerName;
	
	@NotBlank(message="email required")
	@Pattern(regexp="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",message="Please provide a valid email address")
	private String email;
	
	@NotBlank(message="username required")
	private String username;
	
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name="customer_role",
	joinColumns = @JoinColumn(referencedColumnName = "customerId",name="customer_id"),
	inverseJoinColumns = @JoinColumn(referencedColumnName = "roleId",name="role_id")
	)
	private Set<RolesAndAuthority> rolesAndAuthorities;
	
	
	@JsonProperty(access=Access.WRITE_ONLY)
	private String password;
	
	@Valid
	@Embedded
	private Address address;
	
	
	
	
	
	

}
