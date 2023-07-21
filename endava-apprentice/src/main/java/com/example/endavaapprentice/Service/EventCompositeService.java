package com.example.endavaapprentice.Service;

import com.example.endavaapprentice.Model.DTOs.EventVenueEventTypeDTO;
import com.example.endavaapprentice.Model.DTOs.TicketCategoryDTO;
import com.example.endavaapprentice.Model.DTOs.VenueDTO;
import com.example.endavaapprentice.Model.Event;
import com.example.endavaapprentice.Model.EventType;
import com.example.endavaapprentice.Model.TicketCategory;
import com.example.endavaapprentice.Model.Venue;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
    public List<EventVenueEventTypeDTO> fetchEventByVenueAndEventType(Long venueID, String eventType) {
        List<EventVenueEventTypeDTO> eventVenueEventTypeDTOS;
        List<Event> eventList = this.eventService.fetchAllEvents();
        eventList = eventList.stream()
                .filter(event -> Objects.equals(event.getVenue().getVenueID(), venueID) && Objects.equals(event.getEventType().getEventTypeName(), eventType))
                .collect(Collectors.toList());
        eventVenueEventTypeDTOS = eventList.stream()
                .map(event -> convertToEventVenueEventTypeDTO(event, convertToVenueDTO(event.getVenue()), convertToTicketCategoryDTOList(event.getTicketCategoryList())))
                .collect(Collectors.toList());
        return eventVenueEventTypeDTOS;
    }

    private EventVenueEventTypeDTO convertToEventVenueEventTypeDTO(Event event, VenueDTO venueDTO, List<TicketCategoryDTO> ticketCategoryDTOS){
        return new EventVenueEventTypeDTO(
                event.getEventID(),
                venueDTO,
                event.getEventType().getEventTypeName(),
                event.getEventDescription(),
                event.getStartDate(),
                event.getEndDate(),
                ticketCategoryDTOS
        );
    }

    private List<TicketCategoryDTO> convertToTicketCategoryDTOList(List<TicketCategory> ticketCategoryList){
        return ticketCategoryList.stream()
                .map(ticketCategory -> new TicketCategoryDTO(ticketCategory.getTicketCategoryID(), ticketCategory.getDescription(), ticketCategory.getPrice()))
                .collect(Collectors.toList());
    }

    private VenueDTO convertToVenueDTO(Venue venue){
        return new VenueDTO(
                venue.getVenueID(),
                venue.getLocation(),
                venue.getType(),
                venue.getCapacity()
        );
    }
    /*
    @Override
    public EventVenueEventTypeDTO fetchEventByVenueAndEventType(Long venueID, String eventType) {
        List<Event> eventList = this.eventService.fetchAllEvents();
        List<TicketCategoryDTO> ticketCategoryDTOS = new ArrayList<>();
        for(Event event: eventList){
            if(Objects.equals(event.getVenue().getVenueID(), venueID) && Objects.equals(event.getEventType().getEventTypeName(), eventType)){
                Venue venue = event.getVenue();
                VenueDTO venueDTO = new VenueDTO(venue.getVenueID(), venue.getLocation(), venue.getType(), venue.getCapacity());
                for(TicketCategory ticketCategory: event.getTicketCategoryList()){
                    TicketCategoryDTO ticketCategoryDTO = new TicketCategoryDTO(
                            ticketCategory.getTicketCategoryID(),
                            ticketCategory.getDescription(),
                            ticketCategory.getPrice()
                    );
                    ticketCategoryDTOS.add(ticketCategoryDTO);
                }
                EventVenueEventTypeDTO eventVenueEventTypeDTO = new EventVenueEventTypeDTO(
                        event.getEventID(),
                        venueDTO,
                        eventType,
                        event.getEventDescription(),
                        event.getStartDate(),
                        event.getEndDate(),
                        ticketCategoryDTOS
                );
                return eventVenueEventTypeDTO;
            }
        }
        return null;
    }
    */
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
