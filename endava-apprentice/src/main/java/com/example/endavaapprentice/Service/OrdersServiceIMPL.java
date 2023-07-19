package com.example.endavaapprentice.Service;

import com.example.endavaapprentice.Model.Customer;
import com.example.endavaapprentice.Model.Orders;
import com.example.endavaapprentice.Model.TicketCategory;
import com.example.endavaapprentice.Repository.CustomerRepo;
import com.example.endavaapprentice.Repository.OrdersRepo;
import com.example.endavaapprentice.Repository.TicketCategoryRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceIMPL implements IOrdersService{
    private OrdersRepo ordersRepo;
    private CustomerRepo customerRepo;
    private TicketCategoryRepo ticketCategoryRepo;

    public OrdersServiceIMPL(OrdersRepo ordersRepo, CustomerRepo customerRepo, TicketCategoryRepo ticketCategoryRepo){
        this.customerRepo = customerRepo;
        this.ordersRepo = ordersRepo;
        this.ticketCategoryRepo = ticketCategoryRepo;
    }

    @Override
    public Orders add(Orders orders, Long customerID, Long ticketCategoryID) {
        Customer customer = this.customerRepo.findById(customerID).get();
        TicketCategory ticketCategory = this.ticketCategoryRepo.findById(ticketCategoryID).get();
        orders.setCustomer(customer);
        orders.setTicketCategory(ticketCategory);
        return this.ordersRepo.save(orders);
    }

    @Override
    public Orders fetchOne(Long ordersID) {
        return this.ordersRepo.findById(ordersID).get();
    }

    @Override
    public List<Orders> fetchAll() {
        return (List<Orders>) this.ordersRepo.findAll();
    }

    @Override
    public Orders update(Orders orders, Long ordersID) {
        Orders updateOrders = this.ordersRepo.findById(ordersID).get();
        updateOrders.setOrderedAt(orders.getOrderedAt());
        updateOrders.setTotalPrice(orders.getTotalPrice());
        updateOrders.setNumberOfTickets(orders.getNumberOfTickets());
        return this.ordersRepo.save(updateOrders);
    }

    @Override
    public void delete(Long ordersID) {
        this.ordersRepo.deleteById(ordersID);
    }
}