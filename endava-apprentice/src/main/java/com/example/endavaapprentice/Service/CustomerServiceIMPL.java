package com.example.endavaapprentice.Service;

import com.example.endavaapprentice.Model.Customer;
import com.example.endavaapprentice.Repository.CustomerRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceIMPL implements ICustomerService{
    private CustomerRepo customerRepo;

    public CustomerServiceIMPL(CustomerRepo customerRepo){
        this.customerRepo = customerRepo;
    }


    @Override
    public Customer add(Customer customer) {
        return this.customerRepo.save(customer);
    }

    @Override
    public Customer fetchOne(Long customerID) {
        return this.customerRepo.findById(customerID).get();
    }

    @Override
    public List<Customer> fetchAll() {
        return (List<Customer>) this.customerRepo.findAll();
    }

    @Override
    public void delete(Long customerID) {
        this.customerRepo.deleteById(customerID);
    }

    @Override
    public Customer update(Customer customer, long customerID){
        Customer updateCustomer = this.customerRepo.findById(customerID).get();
        updateCustomer.setCustomerName(customer.getCustomerName());
        updateCustomer.setEmail(customer.getEmail());

        return this.customerRepo.save(updateCustomer);
    }
}
