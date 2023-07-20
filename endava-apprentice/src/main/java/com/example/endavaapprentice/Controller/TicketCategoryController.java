package com.example.endavaapprentice.Controller;

import com.example.endavaapprentice.Model.TicketCategory;
import com.example.endavaapprentice.Service.ITicketCategoryCompositeService;
import com.example.endavaapprentice.Service.TicketCategoryCompositeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ticketCategory")
public class TicketCategoryController {
    private ITicketCategoryCompositeService ticketCategoryCompositeService;

    public TicketCategoryController(TicketCategoryCompositeService ticketCategoryCompositeService){
        this.ticketCategoryCompositeService = ticketCategoryCompositeService;
    }

    @GetMapping("/{ticketCategoryID}")
    public TicketCategory fetchOne(@PathVariable("ticketCategoryID") Long ticketCategoryID){
        return this.ticketCategoryCompositeService.fetchOneTicketCategory(ticketCategoryID);
    }

    @GetMapping
    public List<TicketCategory> fetchAll(){
        return this.ticketCategoryCompositeService.fetchAllTicketCategories();
    }

    @PostMapping("/event/{eventID}")
    public TicketCategory add(@RequestBody TicketCategory ticketCategory, @PathVariable("eventID") Long eventID){
        return this.ticketCategoryCompositeService.createTicketCategory(ticketCategory, eventID);
    }

    @PutMapping("/{ticketCategoryID}")
    public TicketCategory update(@RequestBody TicketCategory ticketCategory, @PathVariable("ticketCategoryID") Long ticketCategoryID){
        return this.ticketCategoryCompositeService.updateTicketCategory(ticketCategory, ticketCategoryID);
    }

    @DeleteMapping("/{ticketCategoryID}")
    public void delete(@PathVariable("ticketCategoryID") Long ticketCategoryID){
        this.ticketCategoryCompositeService.deleteTicketCategory(ticketCategoryID);
    }
}
