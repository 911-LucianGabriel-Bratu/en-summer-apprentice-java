package com.example.endavaapprentice.Controller;

import com.example.endavaapprentice.Model.EventType;
import com.example.endavaapprentice.Service.EventTypeService;
import com.example.endavaapprentice.Service.IEventTypeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/eventType")
public class EventTypeController {
    private IEventTypeService eventTypeService;

    public EventTypeController(EventTypeService eventTypeService){
        this.eventTypeService = eventTypeService;
    }

    @GetMapping
    public List<EventType> fetchAll(){
        return this.eventTypeService.fetchAllEventTypes();
    }

    @GetMapping("/{eventTypeID}")
    public EventType fetchOne(@PathVariable("eventTypeID") Long eventTypeID){
        return this.eventTypeService.fetchOneEventType(eventTypeID);
    }

    @PostMapping
    public EventType add(@RequestBody EventType eventType){
        return this.eventTypeService.createEventType(eventType);
    }

    @PutMapping("/{eventTypeID}")
    public EventType update(@RequestBody EventType eventType, @PathVariable("eventTypeID") Long eventTypeID){
        return this.eventTypeService.updateEventType(eventType, eventTypeID);
    }

    @DeleteMapping("/{eventTypeID}")
    public void delete(@PathVariable("eventTypeID") Long eventTypeID){
        this.eventTypeService.deleteEventType(eventTypeID);
    }
}
