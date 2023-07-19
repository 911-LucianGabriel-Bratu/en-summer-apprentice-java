package com.example.endavaapprentice.Controller;

import com.example.endavaapprentice.Model.Event;
import com.example.endavaapprentice.Service.EventService;
import com.example.endavaapprentice.Service.IEventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/event")
public class EventController {
    private IEventService eventService;

    public EventController(EventService eventService){
        this.eventService = eventService;
    }

    @GetMapping("/{eventID}")
    public Event fetchOne(@PathVariable("eventID") Long eventID){
        return this.eventService.fetchOneEvent(eventID);
    }

    @GetMapping
    public List<Event> fetchAll(){
        return this.eventService.fetchAllEvents();
    }

    @PostMapping("/venue/{venueID}/eventType/{eventTypeID}")
    public Event add(@RequestBody Event event, @PathVariable("venueID") Long venueID, @PathVariable("eventTypeID") Long eventTypeID){
        return this.eventService.createEvent(event, venueID, eventTypeID);
    }

    @PutMapping("/{eventID}")
    public Event update(@RequestBody Event event, @PathVariable("eventID") Long eventID){
        return this.eventService.updateEvent(event, eventID);
    }

    @DeleteMapping("/{eventID}")
    public void delete(@PathVariable("eventID") Long eventID){
        this.eventService.deleteEvent(eventID);
    }
}
