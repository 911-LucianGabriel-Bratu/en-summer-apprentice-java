package com.example.endavaapprentice.Controller;

import com.example.endavaapprentice.Model.Customer;
import com.example.endavaapprentice.Service.CustomerServiceIMPL;
import com.example.endavaapprentice.Service.ICustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    private ICustomerService customerService;

    public CustomerController(CustomerServiceIMPL customerService){
        this.customerService = customerService;
    }

    @GetMapping("/api/customer/{customerID}")
    public Customer fetchOne(@PathVariable("customerID") long customerID){
        return this.customerService.fetchOne(customerID);
    }

    @GetMapping("/api/customer")
    public List<Customer> fetchAll(){
        return this.customerService.fetchAll();
    }

    @PostMapping("/api/customer")
    public Customer add(@RequestBody Customer customer){
        return this.customerService.add(customer);
    }

    @PutMapping("/api/customer/{customerID}")
    public Customer update(@RequestBody Customer customer, @PathVariable("customerID") long customerID){
        return this.customerService.update(customer, customerID);
    }

    @DeleteMapping("/api/customer/{customerID}")
    public void delete(@PathVariable("customerID") long customerID){
        this.customerService.delete(customerID);
    }
}
