package com.example.endavaapprentice.Service;

import com.example.endavaapprentice.Model.Event;
import com.example.endavaapprentice.Repository.EventRepo;

import java.util.List;

public interface IEventService {
    EventRepo getEventRepo();
    Event createEvent(Event event);
    Event fetchOneEvent(Long eventID);
    List<Event> fetchAllEvents();
    void deleteEvent(Long eventID);
    Event updateEvent(Event event, Long eventID);
}
