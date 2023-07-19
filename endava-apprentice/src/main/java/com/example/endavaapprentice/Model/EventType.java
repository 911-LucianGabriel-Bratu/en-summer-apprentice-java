package com.example.endavaapprentice.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "EventType", schema = "dbo")
public class EventType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventTypeID;

    @Column(name = "eventTypeName", unique = true)
    private String eventTypeName;

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
}
