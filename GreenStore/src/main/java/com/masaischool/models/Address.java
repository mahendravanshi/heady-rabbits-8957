package com.masaischool.models;



import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {

	@Min(value=1L,message="house no should be greater than 0")
	private Integer houseNo;
	
	@NotBlank(message="Colony  required")
	private String colony;
	
	@NotBlank(message="City required")
	private String city;
	
	@NotBlank(message="State  required")
	private String state;
	
	
	@Pattern(regexp="^[1-9]+[0-9]{5}$",message="Please provide proper six digit pinCode")
	private String pinCode;
	
	
	
}
