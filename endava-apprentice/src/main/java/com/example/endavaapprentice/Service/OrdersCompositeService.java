package com.example.endavaapprentice.Service;

import com.example.endavaapprentice.Model.Customer;
import com.example.endavaapprentice.Model.DTOs.EventOrdersDTO;
import com.example.endavaapprentice.Model.Orders;
import com.example.endavaapprentice.Model.TicketCategory;
import com.example.endavaapprentice.Repository.CustomerRepo;
import com.example.endavaapprentice.Repository.OrdersRepo;
import com.example.endavaapprentice.Repository.TicketCategoryRepo;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;

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
    public EventOrdersDTO fetchOneByCustomerID(Long customerID){
        List<Orders> ordersList = this.ordersService.fetchAllOrders();
        for(Orders orders: ordersList){
            if(Objects.equals(orders.getCustomer().getCustomerID(), customerID)){
                return new EventOrdersDTO(
                        orders.getTicketCategory().getEvent().getEventID(),
                        orders.getOrderedAt(),
                        orders.getTicketCategory().getTicketCategoryID(),
                        orders.getNumberOfTickets(),
                        orders.getTotalPrice()
                );
            }
        }
        return null;
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
    public EventOrdersDTO placeOrderByEventID(Long eventID, Long ticketCategoryID, Long customerID, int numberOfTickets) {
        TicketCategory ticketCategory = this.ticketCategoryService.fetchOneTicketCategory(ticketCategoryID);
        BigDecimal totalPrice = ticketCategory.getPrice();
        totalPrice = totalPrice.multiply(BigDecimal.valueOf(numberOfTickets));
        Orders orders = new Orders();
        orders.setOrderedAt(new Date());
        orders.setNumberOfTickets(numberOfTickets);
        orders.setTotalPrice(totalPrice);

        this.placeOrder(orders, customerID, ticketCategoryID);
        return new EventOrdersDTO(
                eventID,
                orders.getOrderedAt(),
                ticketCategoryID,
                numberOfTickets,
                totalPrice
        );
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
