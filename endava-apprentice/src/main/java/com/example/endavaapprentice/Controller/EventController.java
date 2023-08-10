package com.example.endavaapprentice.Controller;

import com.example.endavaapprentice.Model.DTOs.EventVenueEventTypeDTO;
import com.example.endavaapprentice.Model.Event;
import com.example.endavaapprentice.Service.EventCompositeService;
import com.example.endavaapprentice.Service.IEventCompositeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/event")
public class EventController {
    private IEventCompositeService eventCompositeService;

    public EventController(EventCompositeService eventCompositeService){
        this.eventCompositeService = eventCompositeService;
    }

    @GetMapping("/{eventID}")
    public Event fetchOne(@PathVariable("eventID") Long eventID){
        return this.eventCompositeService.fetchOneEvent(eventID);
    }

    @GetMapping
    public List<Event> fetchAll(){
        return this.eventCompositeService.fetchAllEvents();
    }

    @GetMapping("/venue/{venueID}/eventType/{eventTypeName}")
    public List<EventVenueEventTypeDTO> fetchEventByVenueAndEventType(@PathVariable("venueID") Long venueID, @PathVariable("eventTypeName") String eventTypeName){
        return this.eventCompositeService.fetchEventByVenueAndEventType(venueID, eventTypeName);
    }

    @GetMapping("/{eventID}/ticketCategory/{ticketCategoryType}")
    public Long fetchTicketCategoryIDForEventIDAndTicketType(@PathVariable("eventID") Long eventID, @PathVariable("ticketCategoryType") String ticketCategoryType){
        return this.eventCompositeService.fetchTicketCategoryIDForEventIDAndTicketType(eventID, ticketCategoryType);
    }

    @PostMapping("/venue/{venueID}/eventType/{eventTypeID}")
    public Event add(@RequestBody Event event, @PathVariable("venueID") Long venueID, @PathVariable("eventTypeID") Long eventTypeID){
        return this.eventCompositeService.createEvent(event, venueID, eventTypeID);
    }

    @PutMapping("/{eventID}")
    public Event update(@RequestBody Event event, @PathVariable("eventID") Long eventID){
        return this.eventCompositeService.updateEvent(event, eventID);
    }

    @DeleteMapping("/{eventID}")
    public void delete(@PathVariable("eventID") Long eventID){
        this.eventCompositeService.deleteEvent(eventID);
    }
}
