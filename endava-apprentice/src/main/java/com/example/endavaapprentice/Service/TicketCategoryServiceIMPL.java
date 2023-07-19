package com.example.endavaapprentice.Service;

import com.example.endavaapprentice.Model.Event;
import com.example.endavaapprentice.Model.TicketCategory;
import com.example.endavaapprentice.Repository.EventRepo;
import com.example.endavaapprentice.Repository.TicketCategoryRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketCategoryServiceIMPL implements ITicketCategoryService{
    private TicketCategoryRepo ticketCategoryRepo;

    private EventRepo eventRepo;

    public TicketCategoryServiceIMPL(TicketCategoryRepo ticketCategoryRepo, EventRepo eventRepo){
        this.ticketCategoryRepo = ticketCategoryRepo;
        this.eventRepo = eventRepo;
    }

    @Override
    public TicketCategory fetchOne(Long ticketCategoryID) {
        return this.ticketCategoryRepo.findById(ticketCategoryID).get();
    }

    @Override
    public List<TicketCategory> fetchAll() {
        return (List<TicketCategory>) this.ticketCategoryRepo.findAll();
    }

    @Override
    public TicketCategory save(TicketCategory ticketCategory, Long eventID) {
        Event event = this.eventRepo.findById(eventID).get();
        ticketCategory.setEvent(event);
        return this.ticketCategoryRepo.save(ticketCategory);
    }

    @Override
    public TicketCategory update(TicketCategory ticketCategory, Long ticketCategoryID) {
        TicketCategory updateTicketCategory = this.ticketCategoryRepo.findById(ticketCategoryID).get();
        updateTicketCategory.setDescription(ticketCategory.getDescription());
        updateTicketCategory.setPrice(ticketCategory.getPrice());
        return this.ticketCategoryRepo.save(updateTicketCategory);
    }

    @Override
    public void delete(Long ticketCategoryID) {
        this.ticketCategoryRepo.deleteById(ticketCategoryID);
    }
}
