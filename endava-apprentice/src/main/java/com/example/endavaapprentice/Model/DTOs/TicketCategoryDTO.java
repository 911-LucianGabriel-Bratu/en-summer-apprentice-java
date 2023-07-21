package com.example.endavaapprentice.Model.DTOs;

import java.math.BigDecimal;

public class TicketCategoryDTO {
    private Long ticketCategoryID;
    private String description;
    private BigDecimal price;

    public TicketCategoryDTO(Long ticketCategoryID, String description, BigDecimal price) {
        this.ticketCategoryID = ticketCategoryID;
        this.description = description;
        this.price = price;
    }

    public Long getTicketCategoryID() {
        return ticketCategoryID;
    }

    public void setTicketCategoryID(Long ticketCategoryID) {
        this.ticketCategoryID = ticketCategoryID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
