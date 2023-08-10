package com.example.endavaapprentice.Service;

import com.example.endavaapprentice.Model.DTOs.OrdersDTO;
import com.example.endavaapprentice.Model.Orders;

import java.util.List;

public interface IOrdersService {
    Orders placeOrder(Orders orders);

    void placeOrderByBody(Orders orders);
    List<OrdersDTO> fetchAllOrderDTOs();

    List<OrdersDTO> fetchAllOrderDTOsByCustomerID(Long customerID);
    Orders fetchOneOrder(Long ordersID);
    List<Orders> fetchAllOrders();
    Orders updateOrder(Orders orders, Long ordersID);
    void deleteOrder(Long ordersID);
}
