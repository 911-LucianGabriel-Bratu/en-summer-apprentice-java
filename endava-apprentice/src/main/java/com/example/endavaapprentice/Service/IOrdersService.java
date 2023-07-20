package com.example.endavaapprentice.Service;

import com.example.endavaapprentice.Model.Orders;

import java.util.List;

public interface IOrdersService {
    Orders placeOrder(Orders orders);
    Orders fetchOneOrder(Long ordersID);
    List<Orders> fetchAllOrders();
    Orders updateOrder(Orders orders, Long ordersID);
    void deleteOrder(Long ordersID);
}
