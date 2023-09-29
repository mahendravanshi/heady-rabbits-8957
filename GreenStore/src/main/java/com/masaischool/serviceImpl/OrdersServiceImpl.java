package com.masaischool.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import com.masaischool.exceptions.OrderNotFoundException;
import com.masaischool.exceptions.PriceException;
import com.masaischool.models.Orders;
import com.masaischool.repository.OrdersRepository;
import com.masaischool.service.OrdersService;

public class OrdersServiceImpl implements OrdersService {

	
	@Autowired
	private OrdersRepository ordersRepository;
	
	public Orders getById(Integer orderId) {
		
		Orders orders = ordersRepository.findById(orderId).orElseThrow(()->new OrderNotFoundException("No order found with order id "+orderId));
		
		return orders;
				
	}

	@Override
	public Orders addOrder(Orders order) {
		
		
		Double totalPricePlant = order.getPlants().stream().map(x->x.getPlantCost()*x.getQuantity()).toList().get(0);
		Double totalPriceSeed = order.getSeeds().stream().map(x->x.getSeedCost()*x.getQuantity()).toList().get(0);
		Double totalPricePlanter = order.getPlanters().stream().map(x->x.getPlanterCost()*x.getQuantity()).toList().get(0);

		Double priceDouble = totalPricePlant+totalPricePlanter+totalPriceSeed;
		
		order.setTotalCost(priceDouble);
		

		return ordersRepository.save(order);
	
	}

	@Override
	public Orders updateOrder(Orders updatedOrder, Integer orderId) {
		
		  Orders orders  = getById(orderId);
		  
		    Double totalPricePlant = updatedOrder.getPlants().stream().map(x->x.getPlantCost()*x.getQuantity()).toList().get(0);
			Double totalPriceSeed = updatedOrder.getSeeds().stream().map(x->x.getSeedCost()*x.getQuantity()).toList().get(0);
			Double totalPricePlanter = updatedOrder.getPlanters().stream().map(x->x.getPlanterCost()*x.getQuantity()).toList().get(0);

			Double priceDouble = totalPricePlant+totalPricePlanter+totalPriceSeed;
			
			if(priceDouble>0.0) {
				
				updatedOrder.setTotalCost(priceDouble);
			}
			else {
				throw new PriceException("Price should be greater than 0");
			}


			
			updatedOrder.setTransactionMode(orders.getTransactionMode());
			
			
		  
		  updatedOrder.setOrderId(orderId);
		  
		  ordersRepository.save(updatedOrder);
		  
		  return updatedOrder;
	}

	@Override
	public Orders deleteOrder(Integer orderId) {
		
		Orders orders = getById(orderId);
		
		ordersRepository.deleteById(orderId);
		
		return orders;
	}

	@Override
	public Orders viewOrder(Integer orderId) {
		
		Orders orders = getById(orderId);
		
		return orders;
	}

	@Override
	public List<Orders> viewOrdersAllOrders(String fieldOne, String dirOne, Integer pageNumber,Integer pageSize) {
		
		
		Sort sort = dirOne.equalsIgnoreCase("asc")?Sort.by(Sort.Direction.ASC,fieldOne):Sort.by(Sort.Direction.DESC,fieldOne);
		
		Pageable pageable2 = PageRequest.of(pageNumber, pageSize,sort);
		
		Page<Orders> page = ordersRepository.findAll(pageable2);
		
		if(page.hasContent()) {
			return page.getContent();
		}
		
		throw new OrderNotFoundException("Order not found for this page");
		
	}
	
	
}
