package com.example.endavaapprentice.Service;

import com.example.endavaapprentice.Model.Orders;

import java.util.List;

public interface IOrdersService {
    Orders add(Orders orders, Long customerID, Long ticketCategoryID);
    Orders fetchOne(Long ordersID);
    List<Orders> fetchAll();
    Orders update(Orders orders, Long ordersID);
    void delete(Long ordersID);
}
