package com.example.endavaapprentice.Controller;

import com.example.endavaapprentice.Model.Customer;
import com.example.endavaapprentice.Service.CustomerService;
import com.example.endavaapprentice.Service.ICustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    private ICustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping("/{customerID}")
    public Customer fetchOneCustomer(@PathVariable("customerID") long customerID){
        return this.customerService.fetchOneCustomer(customerID);
    }

    @GetMapping
    public List<Customer> fetchAllCustomers(){
        return this.customerService.fetchAllCustomers();
    }

    @PostMapping
    public Customer registerCustomer(@RequestBody Customer customer){
        return this.customerService.registerCustomer(customer);
    }

    @PutMapping("/{customerID}")
    public Customer updateCustomer(@RequestBody Customer customer, @PathVariable("customerID") long customerID){
        return this.customerService.updateCustomer(customer, customerID);
    }

    @DeleteMapping("/{customerID}")
    public void deleteCustomer(@PathVariable("customerID") long customerID){
        this.customerService.deleteCustomer(customerID);
    }
}
