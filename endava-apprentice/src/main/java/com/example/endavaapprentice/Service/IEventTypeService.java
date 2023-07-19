package com.example.endavaapprentice.Service;


import com.example.endavaapprentice.Model.EventType;

import java.util.List;

public interface IEventTypeService {
    EventType createEventType(EventType eventType);
    EventType fetchOneEventType(Long eventTypeID);
    List<EventType> fetchAllEventTypes();
    void deleteEventType(Long eventTypeID);

    EventType updateEventType(EventType eventType, Long eventTypeID);
}
