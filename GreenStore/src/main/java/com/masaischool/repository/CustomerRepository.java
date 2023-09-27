package com.masaischool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masaischool.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
