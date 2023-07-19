package com.example.endavaapprentice.Service;

import com.example.endavaapprentice.Model.Customer;
import com.example.endavaapprentice.Repository.CustomerRepo;

import java.util.List;

public interface ICustomerService {
    CustomerRepo getCustomerRepo();
    Customer registerCustomer(Customer customer);
    Customer fetchOneCustomer(Long customerID);
    List<Customer> fetchAllCustomers();
    void deleteCustomer(Long customerID);

    Customer updateCustomer(Customer customer, long customerID);
}
