package com.example.endavaapprentice.Controller;

import com.example.endavaapprentice.Model.Orders;
import com.example.endavaapprentice.Service.IOrdersService;
import com.example.endavaapprentice.Service.OrdersService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {
    private IOrdersService ordersService;

    public OrdersController(OrdersService ordersService){
        this.ordersService = ordersService;
    }

    @GetMapping("/{orderID}")
    public Orders fetchOne(@PathVariable("orderID") Long orderID){
        return this.ordersService.fetchOneOrder(orderID);
    }

    @GetMapping
    public List<Orders> fetchAll(){
        return this.ordersService.fetchAllOrders();
    }

    @PostMapping("/customer/{customerID}/ticketCategory/{ticketCategoryID}")
    public Orders add(@RequestBody Orders orders, @PathVariable("customerID") Long customerID, @PathVariable("ticketCategoryID") Long ticketCategoryID){
        return this.ordersService.placeOrder(orders, customerID, ticketCategoryID);
    }

    @PutMapping("/{orderID}")
    public Orders update(@RequestBody Orders orders, @PathVariable("orderID") Long orderID){
        return this.ordersService.updateOrder(orders, orderID);
    }

    @DeleteMapping("/{orderID}")
    public void delete(@PathVariable("orderID") Long orderID){
        this.ordersService.deleteOrder(orderID);
    }
}
