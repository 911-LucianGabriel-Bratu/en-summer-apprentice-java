package com.example.endavaapprentice.Model.DTOs;

import java.math.BigDecimal;
import java.util.Date;

public class EventOrdersDTO {
    private Long eventID;
    private Date timestamp;
    private Long ticketCategoryID;
    private int numberOfTickets;
    private BigDecimal totalPrice;

    public EventOrdersDTO(Long eventID, Date timestamp, Long ticketCategoryID, int numberOfTickets, BigDecimal totalPrice) {
        this.eventID = eventID;
        this.timestamp = timestamp;
        this.ticketCategoryID = ticketCategoryID;
        this.numberOfTickets = numberOfTickets;
        this.totalPrice = totalPrice;
    }

    public Long getEventID() {
        return eventID;
    }

    public void setEventID(Long eventID) {
        this.eventID = eventID;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Long getTicketCategoryID() {
        return ticketCategoryID;
    }

    public void setTicketCategoryID(Long ticketCategoryID) {
        this.ticketCategoryID = ticketCategoryID;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
