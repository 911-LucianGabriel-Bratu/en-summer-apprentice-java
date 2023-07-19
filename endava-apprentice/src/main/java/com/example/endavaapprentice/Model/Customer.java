package com.example.endavaapprentice.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Customer", schema = "dbo")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerID;

    @Column(name = "customerName")
    private String customerName;

    @Column(name = "email", unique = true)
    private String email;

    @OneToMany(mappedBy = "customer")
    List<Orders> ordersList;

    public Customer(){
    }

    public Long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Long customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }
}
