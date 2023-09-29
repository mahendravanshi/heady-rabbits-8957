package com.masaischool.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.masaischool.models.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {

	
	  Page<Orders> findAllOrdersBySortByPagination(Pageable pageable);
}
