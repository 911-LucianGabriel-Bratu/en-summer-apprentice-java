package com.example.endavaapprentice.Controller;

import com.example.endavaapprentice.Model.EventType;
import com.example.endavaapprentice.Service.EventTypeServiceIMPL;
import com.example.endavaapprentice.Service.IEventTypeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventTypeController {
    private IEventTypeService eventTypeService;

    public EventTypeController(EventTypeServiceIMPL eventTypeService){
        this.eventTypeService = eventTypeService;
    }

    @GetMapping("/api/eventType")
    public List<EventType> fetchAll(){
        return this.eventTypeService.fetchAll();
    }

    @GetMapping("/api/eventType/{eventTypeID}")
    public EventType fetchOne(@PathVariable("eventTypeID") long eventTypeID){
        return this.eventTypeService.fetchOne(eventTypeID);
    }

    @PostMapping("/api/eventType")
    public EventType add(@RequestBody EventType eventType){
        return this.eventTypeService.add(eventType);
    }

    @PutMapping("/api/eventType/{eventTypeID}")
    public EventType update(@RequestBody EventType eventType, @PathVariable("eventTypeID") long eventTypeID){
        return this.eventTypeService.update(eventType, eventTypeID);
    }

    @DeleteMapping("/api/eventType/{eventTypeID}")
    public void delete(@PathVariable("eventTypeID") long eventTypeID){
        this.eventTypeService.delete(eventTypeID);
    }
}
