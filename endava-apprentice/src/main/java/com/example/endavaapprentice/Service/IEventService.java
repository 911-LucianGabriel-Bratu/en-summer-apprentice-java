package com.example.endavaapprentice.Service;

import com.example.endavaapprentice.Model.Event;

import java.util.List;

public interface IEventService {
    Event createEvent(Event event, Long venueID, Long eventTypeID);
    Event fetchOneEvent(Long eventID);
    List<Event> fetchAllEvents();
    void deleteEvent(Long eventID);
    Event updateEvent(Event event, Long eventID);
}
