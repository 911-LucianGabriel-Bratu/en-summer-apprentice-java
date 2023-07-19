package com.example.endavaapprentice.Service;

import com.example.endavaapprentice.Model.Customer;

import java.util.List;

public interface ICustomerService {
    Customer add(Customer customer);
    Customer fetchOne(Long customerID);
    List<Customer> fetchAll();
    void delete(Long customerID);

    Customer update(Customer customer, long customerID);
}
