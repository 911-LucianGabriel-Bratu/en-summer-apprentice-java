package com.example.endavaapprentice.Repository;

import com.example.endavaapprentice.Model.Orders;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepo extends CrudRepository<Orders, Long> {
}
