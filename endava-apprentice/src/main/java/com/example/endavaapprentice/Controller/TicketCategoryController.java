package com.example.endavaapprentice.Controller;

import com.example.endavaapprentice.Model.TicketCategory;
import com.example.endavaapprentice.Service.ITicketCategoryService;
import com.example.endavaapprentice.Service.TicketCategoryServiceIMPL;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TicketCategoryController {
    private ITicketCategoryService ticketCategoryService;

    public TicketCategoryController(TicketCategoryServiceIMPL ticketCategoryService){
        this.ticketCategoryService = ticketCategoryService;
    }

    @GetMapping("/api/ticketCategory/{ticketCategoryID}")
    public TicketCategory fetchOne(@PathVariable("ticketCategoryID") Long ticketCategoryID){
        return this.ticketCategoryService.fetchOne(ticketCategoryID);
    }

    @GetMapping("/api/ticketCategory")
    public List<TicketCategory> fetchAll(){
        return this.ticketCategoryService.fetchAll();
    }

    @PostMapping("/api/ticketCategory/event/{eventID}")
    public TicketCategory add(@RequestBody TicketCategory ticketCategory, @PathVariable("eventID") Long eventID){
        return this.ticketCategoryService.save(ticketCategory, eventID);
    }

    @PutMapping("/api/ticketCategory/{ticketCategoryID}")
    public TicketCategory update(@RequestBody TicketCategory ticketCategory, @PathVariable("ticketCategoryID") Long ticketCategoryID){
        return this.ticketCategoryService.update(ticketCategory, ticketCategoryID);
    }

    @DeleteMapping("/api/ticketCategory/{ticketCategoryID}")
    public void delete(@PathVariable("ticketCategoryID") Long ticketCategoryID){
        this.ticketCategoryService.delete(ticketCategoryID);
    }
}
