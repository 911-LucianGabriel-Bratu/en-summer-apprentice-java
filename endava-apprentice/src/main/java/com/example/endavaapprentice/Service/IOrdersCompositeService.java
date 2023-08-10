package com.example.endavaapprentice.Service;

import com.example.endavaapprentice.Model.DTOs.EventOrdersDTO;
import com.example.endavaapprentice.Model.DTOs.OrdersDTO;
import com.example.endavaapprentice.Model.Orders;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface IOrdersCompositeService {
    Orders placeOrder(Orders orders, Long customerID, Long ticketCategoryID);
    List<OrdersDTO> fetchAllOrderDTOs();

    List<OrdersDTO> fetchAllOrderDTOsByCustomerID(Long customerID);

    void placeOrderByBody(Long eventID, Long customerID, String ticketCategoryDescription, int numberOfTickets);
    OrdersDTO updateByIDAndTicketCategory(Long orderID, String ticketCategoryType, int numberOfTickets);
    EventOrdersDTO placeOrderByEventID(Long eventID, Long ticketCategoryID, Long customerID, int numberOfTicketsID);
    EventOrdersDTO fetchOneByCustomerID(Long customerID);
    Orders fetchOneOrder(Long ordersID);
    List<Orders> fetchAllOrders();
    Orders updateOrder(Orders orders, Long ordersID);
    void deleteOrder(Long ordersID);
}
