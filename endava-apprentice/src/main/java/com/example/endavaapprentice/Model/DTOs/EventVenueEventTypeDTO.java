package com.example.endavaapprentice.Model.DTOs;

import com.example.endavaapprentice.Model.TicketCategory;
import com.example.endavaapprentice.Model.Venue;

import java.util.Date;
import java.util.List;

public class EventVenueEventTypeDTO {
    private Long eventID;
    private VenueDTO venueDTO;
    private String eventTypeName;
    private String description;
    private Date startDate;
    private Date endDate;
    private List<TicketCategory> ticketCategories;

    public EventVenueEventTypeDTO(Long eventID, VenueDTO venueDTO, String eventTypeName, String description, Date startDate, Date endDate, List<TicketCategory> ticketCategories) {
        this.eventID = eventID;
        this.venueDTO = venueDTO;
        this.eventTypeName = eventTypeName;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.ticketCategories = ticketCategories;
    }

    public Long getEventID() {
        return eventID;
    }

    public void setEventID(Long eventID) {
        this.eventID = eventID;
    }

    public VenueDTO getVenueDTO() {
        return venueDTO;
    }

    public void setVenue(VenueDTO venueDTO) {
        this.venueDTO = venueDTO;
    }

    public String getEventTypeName() {
        return eventTypeName;
    }

    public void setEventTypeName(String eventTypeName) {
        this.eventTypeName = eventTypeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<TicketCategory> getTicketCategories() {
        return ticketCategories;
    }

    public void setTicketCategories(List<TicketCategory> ticketCategories) {
        this.ticketCategories = ticketCategories;
    }
}
