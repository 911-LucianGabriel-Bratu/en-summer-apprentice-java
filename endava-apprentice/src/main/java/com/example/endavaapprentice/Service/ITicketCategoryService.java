package com.example.endavaapprentice.Service;

import com.example.endavaapprentice.Model.TicketCategory;
import com.example.endavaapprentice.Repository.TicketCategoryRepo;

import java.util.List;

public interface ITicketCategoryService {
    TicketCategoryRepo getTicketCategoryRepo();
    TicketCategory fetchOneTicketCategory(Long ticketCategoryID);
    List<TicketCategory> fetchAllTicketCategories();
    TicketCategory createTicketCategory(TicketCategory ticketCategory);
    TicketCategory updateTicketCategory(TicketCategory ticketCategory, Long ticketCategoryID);
    void deleteTicketCategory(Long ticketCategoryID);
}
