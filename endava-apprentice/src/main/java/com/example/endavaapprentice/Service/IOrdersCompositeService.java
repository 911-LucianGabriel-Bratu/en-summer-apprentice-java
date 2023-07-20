package com.example.endavaapprentice.Service;

import com.example.endavaapprentice.Model.DTOs.EventOrdersDTO;
import com.example.endavaapprentice.Model.Orders;

import java.util.List;

public interface IOrdersCompositeService {
    Orders placeOrder(Orders orders, Long customerID, Long ticketCategoryID);

    EventOrdersDTO fetchOneByCustomerID(Long customerID);
    Orders fetchOneOrder(Long ordersID);
    List<Orders> fetchAllOrders();
    Orders updateOrder(Orders orders, Long ordersID);
    void deleteOrder(Long ordersID);
}
