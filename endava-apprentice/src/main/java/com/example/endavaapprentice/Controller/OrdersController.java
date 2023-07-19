package com.example.endavaapprentice.Controller;

import com.example.endavaapprentice.Model.Orders;
import com.example.endavaapprentice.Service.IOrdersService;
import com.example.endavaapprentice.Service.OrdersServiceIMPL;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrdersController {
    private IOrdersService ordersService;

    public OrdersController(OrdersServiceIMPL ordersService){
        this.ordersService = ordersService;
    }

    @GetMapping("/api/orders/{orderID}")
    public Orders fetchOne(@PathVariable("orderID") Long orderID){
        return this.ordersService.fetchOne(orderID);
    }

    @GetMapping("/api/orders")
    public List<Orders> fetchAll(){
        return this.ordersService.fetchAll();
    }

    @PostMapping("/api/orders/customer/{customerID}/ticketCategory/{ticketCategoryID}")
    public Orders add(@RequestBody Orders orders, @PathVariable("customerID") Long customerID, @PathVariable("ticketCategoryID") Long ticketCategoryID){
        return this.ordersService.add(orders, customerID, ticketCategoryID);
    }

    @PutMapping("/api/orders/{orderID}")
    public Orders update(@RequestBody Orders orders, @PathVariable("orderID") Long orderID){
        return this.ordersService.update(orders, orderID);
    }

    @DeleteMapping("/api/orders/{orderID}")
    public void delete(@PathVariable("orderID") Long orderID){
        this.ordersService.delete(orderID);
    }
}
