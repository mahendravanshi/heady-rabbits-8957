package com.masaischool.controllers;



import com.masaischool.models.Orders;
import com.masaischool.service.OrdersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@Slf4j
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @PostMapping("/add")
    public ResponseEntity<Orders> addOrder(@RequestBody Orders order) {
        log.info("Adding a new order: {}", order);
        Orders addedOrder = ordersService.addOrder(order);
        log.info("Order added successfully: {}", addedOrder);
        return new ResponseEntity<>(addedOrder, HttpStatus.CREATED);
    }
    
    @PutMapping("/{orderId}")
    public ResponseEntity<Orders> updateOrder(@PathVariable Integer orderId, @RequestBody Orders updatedOrder) {
        log.info("Updating order with ID {}: {}", orderId, updatedOrder);
        Orders updated = ordersService.updateOrder(updatedOrder, orderId);
        log.info("Order updated successfully: {}", updated);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<Orders> deleteOrder(@PathVariable Integer orderId) {
        log.info("Deleting order with ID: {}", orderId);
        Orders deletedOrder = ordersService.deleteOrder(orderId);
        log.info("Order deleted successfully: {}", deletedOrder);
        return new ResponseEntity<>(deletedOrder, HttpStatus.OK);
    }
     
    
    
    @GetMapping("/view/{orderId}")
    public ResponseEntity<Orders> viewOrder(@PathVariable Integer orderId) {
        log.info("Viewing order with ID: {}", orderId);
        Orders order = ordersService.viewOrder(orderId);
        log.info("Order details: {}", order);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }
     
    @GetMapping("/viewAll")
    public ResponseEntity<List<Orders>> viewAllOrders(@RequestParam String fieldOne, @RequestParam String dirOne,
                                                      @RequestParam Integer pageNumber, @RequestParam Integer pageSize) {
        log.info("Viewing all orders with sorting field: {}, direction: {}, page number: {}, page size: {}", fieldOne, dirOne, pageNumber, pageSize);
        List<Orders> orders = ordersService.viewOrdersAllOrders(fieldOne, dirOne, pageNumber, pageSize);
        log.info("Total {} orders retrieved", orders.size());
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
}

