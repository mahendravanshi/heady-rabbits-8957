package com.masaischool.service;

import java.util.List;

import com.masaischool.models.Orders;

public interface OrdersService {

	
	   public Orders addOrder(Orders order);
	   public Orders updateOrder(Orders order,Integer orderId);
	   public Orders deleteOrder(Integer orderId);
	   public Orders viewOrder(Integer orderId);
	   public List<Orders> viewOrdersAllOrders(String fieldOne,String dirOne,Integer pageNo,Integer pageSize);
	   
	   
}




