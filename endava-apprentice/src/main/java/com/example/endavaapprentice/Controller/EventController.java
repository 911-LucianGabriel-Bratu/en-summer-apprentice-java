package com.example.endavaapprentice.Controller;

import com.example.endavaapprentice.Model.Event;
import com.example.endavaapprentice.Service.EventServiceIMPL;
import com.example.endavaapprentice.Service.IEventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventController {
    private IEventService eventService;

    public EventController(EventServiceIMPL eventService){
        this.eventService = eventService;
    }

    @GetMapping("/api/event/{eventID}")
    public Event fetchOne(@PathVariable("eventID") Long eventID){
        return this.eventService.fetchOne(eventID);
    }

    @GetMapping("/api/event")
    public List<Event> fetchAll(){
        return this.eventService.fetchAll();
    }

    @PostMapping("/api/event/venue/{venueID}/eventType/{eventTypeID}")
    public Event add(@RequestBody Event event, @PathVariable("venueID") Long venueID, @PathVariable("eventTypeID") Long eventTypeID){
        return this.eventService.add(event, venueID, eventTypeID);
    }

    @PutMapping("/api/event/{eventID}")
    public Event update(@RequestBody Event event, @PathVariable("eventID") Long eventID){
        return this.eventService.update(event, eventID);
    }

    @DeleteMapping("/api/event/{eventID}")
    public void delete(@PathVariable("eventID") Long eventID){
        this.eventService.delete(eventID);
    }
}
