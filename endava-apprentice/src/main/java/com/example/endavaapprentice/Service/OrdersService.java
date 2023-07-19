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
public class OrdersService implements IOrdersService{
    private OrdersRepo ordersRepo;

    public OrdersService(OrdersRepo ordersRepo){
        this.ordersRepo = ordersRepo;
    }

    @Override
    public Orders placeOrder(Orders orders) {
        return this.ordersRepo.save(orders);
    }

    @Override
    public Orders fetchOneOrder(Long ordersID) {
        return this.ordersRepo.findById(ordersID).get();
    }

    @Override
    public List<Orders> fetchAllOrders() {
        return (List<Orders>) this.ordersRepo.findAll();
    }

    @Override
    public Orders updateOrder(Orders orders, Long ordersID) {
        Orders updateOrders = this.ordersRepo.findById(ordersID).get();
        updateOrders.setOrderedAt(orders.getOrderedAt());
        updateOrders.setTotalPrice(orders.getTotalPrice());
        updateOrders.setNumberOfTickets(orders.getNumberOfTickets());
        return this.ordersRepo.save(updateOrders);
    }

    @Override
    public void deleteOrder(Long ordersID) {
        this.ordersRepo.deleteById(ordersID);
    }
}
