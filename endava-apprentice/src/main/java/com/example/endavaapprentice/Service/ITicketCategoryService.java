package com.example.endavaapprentice.Service;

import com.example.endavaapprentice.Model.TicketCategory;

import java.util.List;

public interface ITicketCategoryService {
    TicketCategory fetchOne(Long ticketCategoryID);
    List<TicketCategory> fetchAll();
    TicketCategory save(TicketCategory ticketCategory, Long eventID);
    TicketCategory update(TicketCategory ticketCategory, Long ticketCategoryID);
    void delete(Long ticketCategoryID);
}
