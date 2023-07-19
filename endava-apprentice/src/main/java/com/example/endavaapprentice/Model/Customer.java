package com.example.endavaapprentice.Model;

import jakarta.persistence.*;

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
}
