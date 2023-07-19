package com.example.endavaapprentice.Service;

import com.example.endavaapprentice.Model.Event;
import com.example.endavaapprentice.Model.EventType;
import com.example.endavaapprentice.Model.Venue;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventCompositeService implements IEventCompositeService{
    private IEventService eventService;
    private IEventTypeService eventTypeService;
    private IVenueService venueService;

    public EventCompositeService(EventService eventService, EventTypeService eventTypeService, VenueService venueService){
        this.eventService = eventService;
        this.eventTypeService = eventTypeService;
        this.venueService = venueService;
    }

    @Override
    public Event createEvent(Event event, Long venueID, Long eventTypeID) {
        Venue venue = this.venueService.getVenueRepo().findById(venueID).get();
        EventType eventType = this.eventTypeService.getEventTypeRepo().findById(eventTypeID).get();
        event.setEventType(eventType);
        event.setVenue(venue);
        return this.eventService.createEvent(event);
    }

    @Override
    public Event fetchOneEvent(Long eventID) {
        return this.eventService.fetchOneEvent(eventID);
    }

    @Override
    public List<Event> fetchAllEvents() {
        return this.eventService.fetchAllEvents();
    }

    @Override
    public void deleteEvent(Long eventID) {
        this.eventService.deleteEvent(eventID);
    }

    @Override
    public Event updateEvent(Event event, Long eventID) {
        return this.eventService.updateEvent(event, eventID);
    }
}
