package com.example.endavaapprentice.Model.DTOs;

import com.example.endavaapprentice.Model.TicketCategory;

import java.util.Date;
import java.util.List;

public class EventVenueEventTypeDTO {
    private Long eventID;
    private VenueDTO venueDTO;
    private String eventTypeName;
    private String description;
    private Date startDate;
    private Date endDate;
    private List<TicketCategoryDTO> ticketCategories;

    public EventVenueEventTypeDTO(Long eventID, VenueDTO venueDTO, String eventTypeName, String description, Date startDate, Date endDate, List<TicketCategoryDTO> ticketCategories) {
        this.eventID = eventID;
        this.venueDTO = venueDTO;
        this.eventTypeName = eventTypeName;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.ticketCategories= ticketCategories;
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

    public List<TicketCategoryDTO> getTicketCategories() {
        return ticketCategories;
    }

    public void setTicketCategories(List<TicketCategoryDTO> ticketCategories) {
        this.ticketCategories = ticketCategories;
    }
}
