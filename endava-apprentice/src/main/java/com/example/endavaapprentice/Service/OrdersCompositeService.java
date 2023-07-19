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
public class OrdersCompositeService implements IOrdersCompositeService{
    private IOrdersService ordersService;

    private ICustomerService customerService;
    private ITicketCategoryService ticketCategoryService;

    public OrdersCompositeService(IOrdersService ordersService, ICustomerService customerService, ITicketCategoryService ticketCategoryService){
        this.customerService = customerService;
        this.ordersService = ordersService;
        this.ticketCategoryService = ticketCategoryService;
    }



    @Override
    public Orders placeOrder(Orders orders, Long customerID, Long ticketCategoryID) {
        Customer customer = this.customerService.getCustomerRepo().findById(customerID).get();
        TicketCategory ticketCategory = this.ticketCategoryService.getTicketCategoryRepo().findById(ticketCategoryID).get();
        orders.setCustomer(customer);
        orders.setTicketCategory(ticketCategory);
        return this.ordersService.placeOrder(orders);
    }

    @Override
    public Orders fetchOneOrder(Long ordersID) {
        return this.ordersService.fetchOneOrder(ordersID);
    }

    @Override
    public List<Orders> fetchAllOrders() {
        return this.ordersService.fetchAllOrders();
    }

    @Override
    public Orders updateOrder(Orders orders, Long ordersID) {
        return this.ordersService.updateOrder(orders, ordersID);
    }

    @Override
    public void deleteOrder(Long ordersID) {
        this.ordersService.deleteOrder(ordersID);
    }
}
