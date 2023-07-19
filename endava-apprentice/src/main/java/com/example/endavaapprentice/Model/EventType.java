package com.example.endavaapprentice.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "EventType", schema = "dbo")
public class EventType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventTypeID;

    @Column(name = "eventTypeName", unique = true)
    private String eventTypeName;

    @OneToMany(mappedBy = "eventType")
    private List<Event> eventList;

    public long getEventTypeID() {
        return eventTypeID;
    }

    public void setEventTypeID(long eventTypeID) {
        this.eventTypeID = eventTypeID;
    }

    public String getEventTypeName() {
        return eventTypeName;
    }

    public void setEventTypeName(String eventTypeName) {
        this.eventTypeName = eventTypeName;
    }

    public void setEventTypeID(Long eventTypeID) {
        this.eventTypeID = eventTypeID;
    }

    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }
}
