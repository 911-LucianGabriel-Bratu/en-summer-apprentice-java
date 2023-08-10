package com.example.endavaapprentice.Service;

import com.example.endavaapprentice.Model.Customer;
import com.example.endavaapprentice.Model.DTOs.EventOrdersDTO;
import com.example.endavaapprentice.Model.DTOs.OrdersDTO;
import com.example.endavaapprentice.Model.Orders;
import com.example.endavaapprentice.Model.TicketCategory;
import com.example.endavaapprentice.Repository.CustomerRepo;
import com.example.endavaapprentice.Repository.OrdersRepo;
import com.example.endavaapprentice.Repository.TicketCategoryRepo;
import jakarta.persistence.criteria.Order;
import org.aspectj.weaver.ast.Or;
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
    public OrdersDTO updateByIDAndTicketCategory(Long orderID, String ticketCategoryType, int numberOfTickets){
        Orders orders = ordersService.fetchOneOrder(orderID);
        TicketCategory ticketCategory = orders.getTicketCategory();
        TicketCategory newTicketCategory = null;
        for(TicketCategory ticketCategory1: ticketCategory.getEvent().getTicketCategoryList()){
            if(Objects.equals(ticketCategory1.getDescription(), ticketCategoryType)){
                newTicketCategory = ticketCategory1;
            }
        }
        orders.setTicketCategory(newTicketCategory);
        orders.setNumberOfTickets(numberOfTickets);
        orders.setTotalPrice(newTicketCategory.getPrice().multiply(BigDecimal.valueOf(numberOfTickets)));
        orders.setOrderedAt(new Date());
        Orders updatedOrder = this.updateOrder(orders, orderID);
        return new OrdersDTO(
                updatedOrder.getOrderID(),
                updatedOrder.getCustomer().getCustomerName(),
                updatedOrder.getTicketCategory().getDescription(),
                updatedOrder.getOrderedAt(),
                updatedOrder.getNumberOfTickets(),
                updatedOrder.getTotalPrice()
        );
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
                        orders.getTotalPrice(),
                        orders.getTicketCategory().getEvent().getImageURL()
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
    public List<OrdersDTO> fetchAllOrderDTOs() {
        return this.ordersService.fetchAllOrderDTOs();
    }

    @Override
    public List<OrdersDTO> fetchAllOrderDTOsByCustomerID(Long customerID) {
        return this.ordersService.fetchAllOrderDTOsByCustomerID(customerID);
    }

    @Override
    public void placeOrderByBody(Long eventID, Long customerID, String ticketCategoryDescription, int numberOfTickets) {
        List<TicketCategory> ticketCategoryList = this.ticketCategoryService.fetchAllTicketCategories();
        Customer customer = this.customerService.fetchOneCustomer(customerID);
        for(TicketCategory ticketCategory: ticketCategoryList){
            if(ticketCategory.getEvent().getEventID() == eventID && Objects.equals(ticketCategory.getDescription(), ticketCategoryDescription)){
                Orders orders = new Orders(new Date(), numberOfTickets, ticketCategory.getPrice().multiply(BigDecimal.valueOf(numberOfTickets)), customer, ticketCategory);
                this.ordersService.placeOrderByBody(orders);
            }
        }
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
                totalPrice,
                ticketCategory.getEvent().getImageURL()
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
