package com.example.endavaapprentice.Controller;

import com.example.endavaapprentice.Model.TicketCategory;
import com.example.endavaapprentice.Service.ITicketCategoryService;
import com.example.endavaapprentice.Service.TicketCategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ticketCategory")
public class TicketCategoryController {
    private ITicketCategoryService ticketCategoryService;

    public TicketCategoryController(TicketCategoryService ticketCategoryService){
        this.ticketCategoryService = ticketCategoryService;
    }

    @GetMapping("/{ticketCategoryID}")
    public TicketCategory fetchOne(@PathVariable("ticketCategoryID") Long ticketCategoryID){
        return this.ticketCategoryService.fetchOneTicketCategory(ticketCategoryID);
    }

    @GetMapping
    public List<TicketCategory> fetchAll(){
        return this.ticketCategoryService.fetchAllTicketCategories();
    }

    @PostMapping("/event/{eventID}")
    public TicketCategory add(@RequestBody TicketCategory ticketCategory, @PathVariable("eventID") Long eventID){
        return this.ticketCategoryService.createTicketCategory(ticketCategory, eventID);
    }

    @PutMapping("/{ticketCategoryID}")
    public TicketCategory update(@RequestBody TicketCategory ticketCategory, @PathVariable("ticketCategoryID") Long ticketCategoryID){
        return this.ticketCategoryService.updateTicketCategory(ticketCategory, ticketCategoryID);
    }

    @DeleteMapping("/{ticketCategoryID}")
    public void delete(@PathVariable("ticketCategoryID") Long ticketCategoryID){
        this.ticketCategoryService.deleteTicketCategory(ticketCategoryID);
    }
}
