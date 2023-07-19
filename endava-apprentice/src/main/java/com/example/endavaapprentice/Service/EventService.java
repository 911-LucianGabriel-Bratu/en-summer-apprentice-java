package com.example.endavaapprentice.Service;

import com.example.endavaapprentice.Model.Event;
import com.example.endavaapprentice.Model.EventType;
import com.example.endavaapprentice.Model.Venue;
import com.example.endavaapprentice.Repository.EventRepo;
import com.example.endavaapprentice.Repository.EventTypeRepo;
import com.example.endavaapprentice.Repository.VenueRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService implements IEventService{
    private EventRepo eventRepo;
    private EventTypeRepo eventTypeRepo;
    private VenueRepo venueRepo;

    public EventService(EventRepo eventRepo, EventTypeRepo eventTypeRepo, VenueRepo venueRepo){
        this.eventRepo = eventRepo;
        this.eventTypeRepo = eventTypeRepo;
        this.venueRepo = venueRepo;
    }

    @Override
    public Event createEvent(Event event, Long venueID, Long eventTypeID) {
        Venue venue = this.venueRepo.findById(venueID).get();
        EventType eventType = this.eventTypeRepo.findById(eventTypeID).get();
        event.setEventType(eventType);
        event.setVenue(venue);
        return this.eventRepo.save(event);
    }

    @Override
    public Event fetchOneEvent(Long eventID) {
        return this.eventRepo.findById(eventID).get();
    }

    @Override
    public List<Event> fetchAllEvents() {
        return (List<Event>) this.eventRepo.findAll();
    }

    @Override
    public void deleteEvent(Long eventID) {
        this.eventRepo.deleteById(eventID);
    }

    @Override
    public Event updateEvent(Event event, Long eventID) {
        Event updateEvent = this.eventRepo.findById(eventID).get();
        updateEvent.setEventName(event.getEventName());
        updateEvent.setEventDescription(event.getEventDescription());
        updateEvent.setStartDate(event.getStartDate());
        updateEvent.setEndDate(event.getEndDate());
        return this.eventRepo.save(updateEvent);
    }
}
