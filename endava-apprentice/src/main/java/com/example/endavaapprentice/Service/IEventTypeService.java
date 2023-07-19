package com.example.endavaapprentice.Service;


import com.example.endavaapprentice.Model.EventType;

import java.util.List;

public interface IEventTypeService {
    EventType add(EventType eventType);
    EventType fetchOne(Long eventTypeID);
    List<EventType> fetchAll();
    void delete(Long eventTypeID);

    EventType update(EventType eventType, long eventTypeID);
}
