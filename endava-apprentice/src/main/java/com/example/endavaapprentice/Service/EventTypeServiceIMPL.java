package com.example.endavaapprentice.Service;

import com.example.endavaapprentice.Model.EventType;
import com.example.endavaapprentice.Repository.EventTypeRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventTypeServiceIMPL implements IEventTypeService{
    private EventTypeRepo eventTypeRepo;

    public EventTypeServiceIMPL(EventTypeRepo eventTypeRepo){
        this.eventTypeRepo = eventTypeRepo;
    }

    @Override
    public EventType add(EventType eventType) {
        return this.eventTypeRepo.save(eventType);
    }

    @Override
    public EventType fetchOne(Long eventTypeID) {
        return this.eventTypeRepo.findById(eventTypeID).get();
    }

    @Override
    public List<EventType> fetchAll() {
        return (List<EventType>) this.eventTypeRepo.findAll();
    }

    @Override
    public void delete(Long eventTypeID) {
        this.eventTypeRepo.deleteById(eventTypeID);
    }

    @Override
    public EventType update(EventType eventType, Long eventTypeID) {
        EventType updateEventType = this.eventTypeRepo.findById(eventTypeID).get();
        updateEventType.setEventTypeName(eventType.getEventTypeName());
        return this.eventTypeRepo.save(updateEventType);
    }
}
