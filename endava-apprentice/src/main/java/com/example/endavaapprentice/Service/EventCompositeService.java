package com.example.endavaapprentice.Service;

import com.example.endavaapprentice.Model.DTOs.EventVenueEventTypeDTO;
import com.example.endavaapprentice.Model.DTOs.VenueDTO;
import com.example.endavaapprentice.Model.Event;
import com.example.endavaapprentice.Model.EventType;
import com.example.endavaapprentice.Model.Venue;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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
    public EventVenueEventTypeDTO fetchEventByVenueAndEventType(Long venueID, String eventType) {
        List<Event> eventList = this.eventService.fetchAllEvents();
        for(Event event: eventList){
            if(Objects.equals(event.getVenue().getVenueID(), venueID) && Objects.equals(event.getEventType().getEventTypeName(), eventType)){
                Venue venue = event.getVenue();
                VenueDTO venueDTO = new VenueDTO(venue.getVenueID(), venue.getLocation(), venue.getType(), venue.getCapacity());
                EventVenueEventTypeDTO eventVenueEventTypeDTO = new EventVenueEventTypeDTO(
                        event.getEventID(),
                        venueDTO,
                        eventType,
                        event.getEventDescription(),
                        event.getStartDate(),
                        event.getEndDate(),
                        event.getTicketCategoryList()
                );
                return eventVenueEventTypeDTO;
            }
        }
        return null;
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
