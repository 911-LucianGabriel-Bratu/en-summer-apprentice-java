package com.example.endavaapprentice.Service;

import com.example.endavaapprentice.Model.TicketCategory;
import com.example.endavaapprentice.Repository.EventRepo;
import com.example.endavaapprentice.Repository.TicketCategoryRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketCategoryService implements ITicketCategoryService{
    private TicketCategoryRepo ticketCategoryRepo;

    public TicketCategoryService(TicketCategoryRepo ticketCategoryRepo, EventRepo eventRepo){
        this.ticketCategoryRepo = ticketCategoryRepo;
    }

    public TicketCategoryRepo getTicketCategoryRepo(){
        return this.ticketCategoryRepo;
    }

    @Override
    public TicketCategory fetchOneTicketCategory(Long ticketCategoryID) {
        return this.ticketCategoryRepo.findById(ticketCategoryID).get();
    }

    @Override
    public List<TicketCategory> fetchAllTicketCategories() {
        return (List<TicketCategory>) this.ticketCategoryRepo.findAll();
    }

    @Override
    public TicketCategory createTicketCategory(TicketCategory ticketCategory) {
        return this.ticketCategoryRepo.save(ticketCategory);
    }

    @Override
    public TicketCategory updateTicketCategory(TicketCategory ticketCategory, Long ticketCategoryID) {
        TicketCategory updateTicketCategory = this.ticketCategoryRepo.findById(ticketCategoryID).get();
        updateTicketCategory.setDescription(ticketCategory.getDescription());
        updateTicketCategory.setPrice(ticketCategory.getPrice());
        return this.ticketCategoryRepo.save(updateTicketCategory);
    }

    @Override
    public void deleteTicketCategory(Long ticketCategoryID) {
        this.ticketCategoryRepo.deleteById(ticketCategoryID);
    }
}
