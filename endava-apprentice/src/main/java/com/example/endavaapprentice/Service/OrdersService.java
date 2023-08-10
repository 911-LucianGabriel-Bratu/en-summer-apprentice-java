package com.example.endavaapprentice.Service;

import com.example.endavaapprentice.Model.Customer;
import com.example.endavaapprentice.Model.DTOs.OrdersDTO;
import com.example.endavaapprentice.Model.Orders;
import com.example.endavaapprentice.Model.TicketCategory;
import com.example.endavaapprentice.Repository.CustomerRepo;
import com.example.endavaapprentice.Repository.OrdersRepo;
import com.example.endavaapprentice.Repository.TicketCategoryRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrdersService implements IOrdersService{
    private OrdersRepo ordersRepo;

    public OrdersService(OrdersRepo ordersRepo){
        this.ordersRepo = ordersRepo;
    }

    public List<OrdersDTO> fetchAllOrderDTOs(){
        List<Orders> ordersList = (List<Orders>) this.ordersRepo.findAll();
        return ordersList.stream()
                .map(orders -> new OrdersDTO(
                        orders.getOrderID(),
                        orders.getCustomer().getCustomerName(),
                        orders.getTicketCategory().getDescription(),
                        orders.getOrderedAt(),
                        orders.getNumberOfTickets(),
                        orders.getTotalPrice()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public List<OrdersDTO> fetchAllOrderDTOsByCustomerID(Long customerID) {
        List<Orders> ordersList = (List<Orders>) this.ordersRepo.findAll();
        return ordersList.stream()
                .filter(orders -> orders.getCustomer().getCustomerID().equals(customerID))
                .map(orders -> new OrdersDTO(
                        orders.getOrderID(),
                        orders.getCustomer().getCustomerName(),
                        orders.getTicketCategory().getDescription(),
                        orders.getOrderedAt(),
                        orders.getNumberOfTickets(),
                        orders.getTotalPrice()
                ))
                .collect(Collectors.toList());
    }


    @Override
    public Orders placeOrder(Orders orders) {
        return this.ordersRepo.save(orders);
    }

    @Override
    public void placeOrderByBody(Orders orders) {
        this.ordersRepo.save(orders);
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
