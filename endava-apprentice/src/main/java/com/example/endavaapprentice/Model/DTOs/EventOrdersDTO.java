package com.example.endavaapprentice.Model.DTOs;

import java.math.BigDecimal;
import java.util.Date;

public class EventOrdersDTO {
    private Long eventID;
    private Date timestamp;
    private Long ticketCategoryID;
    private int numberOfTickets;
    private BigDecimal totalPrice;

    private String imageURL;

    public EventOrdersDTO(Long eventID, Date timestamp, Long ticketCategoryID, int numberOfTickets, BigDecimal totalPrice, String image) {
        this.eventID = eventID;
        this.timestamp = timestamp;
        this.ticketCategoryID = ticketCategoryID;
        this.numberOfTickets = numberOfTickets;
        this.totalPrice = totalPrice;
        this.imageURL = image;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
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
