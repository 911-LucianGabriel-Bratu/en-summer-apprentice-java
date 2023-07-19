package com.example.endavaapprentice.Service;

import com.example.endavaapprentice.Model.EventType;
import com.example.endavaapprentice.Repository.EventTypeRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventTypeService implements IEventTypeService{
    private EventTypeRepo eventTypeRepo;

    public EventTypeService(EventTypeRepo eventTypeRepo){
        this.eventTypeRepo = eventTypeRepo;
    }

    @Override
    public EventType createEventType(EventType eventType) {
        return this.eventTypeRepo.save(eventType);
    }

    @Override
    public EventType fetchOneEventType(Long eventTypeID) {
        return this.eventTypeRepo.findById(eventTypeID).get();
    }

    @Override
    public List<EventType> fetchAllEventTypes() {
        return (List<EventType>) this.eventTypeRepo.findAll();
    }

    @Override
    public void deleteEventType(Long eventTypeID) {
        this.eventTypeRepo.deleteById(eventTypeID);
    }

    @Override
    public EventType updateEventType(EventType eventType, Long eventTypeID) {
        EventType updateEventType = this.eventTypeRepo.findById(eventTypeID).get();
        updateEventType.setEventTypeName(eventType.getEventTypeName());
        return this.eventTypeRepo.save(updateEventType);
    }
}
