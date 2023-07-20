package com.example.endavaapprentice.Controller;

import com.example.endavaapprentice.Model.DTOs.EventOrdersDTO;
import com.example.endavaapprentice.Model.Orders;
import com.example.endavaapprentice.Service.IOrdersCompositeService;
import com.example.endavaapprentice.Service.OrdersCompositeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {
    private IOrdersCompositeService ordersCompositeService;

    public OrdersController(OrdersCompositeService ordersCompositeService){
        this.ordersCompositeService = ordersCompositeService;
    }

    @GetMapping("/{orderID}")
    public Orders fetchOne(@PathVariable("orderID") Long orderID){
        return this.ordersCompositeService.fetchOneOrder(orderID);
    }

    @GetMapping
    public List<Orders> fetchAll(){
        return this.ordersCompositeService.fetchAllOrders();
    }

    @GetMapping("/customer/{customerID}")
    public EventOrdersDTO fetchOneByCustomerID(@PathVariable("customerID") Long customerID){
        return this.ordersCompositeService.fetchOneByCustomerID(customerID);
    }

    @PostMapping("/customer/{customerID}/ticketCategory/{ticketCategoryID}")
    public Orders add(@RequestBody Orders orders, @PathVariable("customerID") Long customerID, @PathVariable("ticketCategoryID") Long ticketCategoryID){
        return this.ordersCompositeService.placeOrder(orders, customerID, ticketCategoryID);
    }

    @PostMapping("/customer/{customerID}")
    public EventOrdersDTO addByCustomerID(@RequestBody Map<String, Object> requestBody, @PathVariable("customerID") Long customerID){
        Integer eventID = (Integer) requestBody.get("eventID");
        Integer ticketCategoryID = (Integer) requestBody.get("ticketCategoryID");
        int numberOfTickets = (int) requestBody.get("numberOfTickets");

        return this.ordersCompositeService.placeOrderByEventID(eventID.longValue(), ticketCategoryID.longValue(), customerID, numberOfTickets);
    }

    @PutMapping("/{orderID}")
    public Orders update(@RequestBody Orders orders, @PathVariable("orderID") Long orderID){
        return this.ordersCompositeService.updateOrder(orders, orderID);
    }

    @DeleteMapping("/{orderID}")
    public void delete(@PathVariable("orderID") Long orderID){
        this.ordersCompositeService.deleteOrder(orderID);
    }
}
