package com.example.endavaapprentice.Service;

import com.example.endavaapprentice.Model.Event;
import com.example.endavaapprentice.Model.TicketCategory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketCategoryCompositeService implements ITicketCategoryCompositeService{
    private ITicketCategoryService ticketCategoryService;
    private IEventService eventService;

    public TicketCategoryCompositeService(TicketCategoryService ticketCategoryService, EventService eventService){
        this.ticketCategoryService = ticketCategoryService;
        this.eventService = eventService;
    }

    @Override
    public TicketCategory fetchOneTicketCategory(Long ticketCategoryID) {
        return ticketCategoryService.fetchOneTicketCategory(ticketCategoryID);
    }

    @Override
    public List<TicketCategory> fetchAllTicketCategories() {
        return this.ticketCategoryService.fetchAllTicketCategories();
    }

    @Override
    public TicketCategory createTicketCategory(TicketCategory ticketCategory, Long eventID) {
        Event event = this.eventService.getEventRepo().findById(eventID).get();
        ticketCategory.setEvent(event);
        return this.ticketCategoryService.createTicketCategory(ticketCategory);
    }

    @Override
    public TicketCategory updateTicketCategory(TicketCategory ticketCategory, Long ticketCategoryID) {
        return this.ticketCategoryService.updateTicketCategory(ticketCategory, ticketCategoryID);
    }

    @Override
    public void deleteTicketCategory(Long ticketCategoryID) {
        this.ticketCategoryService.deleteTicketCategory(ticketCategoryID);
    }
}
