package com.example.endavaapprentice.Service;

import com.example.endavaapprentice.Model.Event;

import java.util.List;

public interface IEventService {
    Event add(Event event, Long venueID, Long eventTypeID);
    Event fetchOne(Long eventID);
    List<Event> fetchAll();
    void delete(Long eventID);
    Event update(Event event, Long eventID);
}
