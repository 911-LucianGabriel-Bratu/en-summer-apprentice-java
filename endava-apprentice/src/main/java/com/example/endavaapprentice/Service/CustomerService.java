package com.example.endavaapprentice.Service;

import com.example.endavaapprentice.Model.Customer;
import com.example.endavaapprentice.Repository.CustomerRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService{
    private CustomerRepo customerRepo;

    public CustomerService(CustomerRepo customerRepo){
        this.customerRepo = customerRepo;
    }

    public CustomerRepo getCustomerRepo(){
        return this.customerRepo;
    }

    @Override
    public Customer registerCustomer(Customer customer) {
        return this.customerRepo.save(customer);
    }

    @Override
    public Customer fetchOneCustomer(Long customerID) {
        return this.customerRepo.findById(customerID).get();
    }

    @Override
    public List<Customer> fetchAllCustomers() {
        return (List<Customer>) this.customerRepo.findAll();
    }

    @Override
    public void deleteCustomer(Long customerID) {
        this.customerRepo.deleteById(customerID);
    }

    @Override
    public Customer updateCustomer(Customer customer, long customerID){
        Customer updateCustomer = this.customerRepo.findById(customerID).get();
        updateCustomer.setCustomerName(customer.getCustomerName());
        updateCustomer.setEmail(customer.getEmail());

        return this.customerRepo.save(updateCustomer);
    }
}
