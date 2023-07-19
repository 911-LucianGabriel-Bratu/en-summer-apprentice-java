package com.example.endavaapprentice.Service;

import com.example.endavaapprentice.Model.Venue;

import java.util.List;

public interface IVenueService {
    Venue fetchOne(Long venueID);
    List<Venue> fetchAll();
    Venue add(Venue venue);
    Venue update(Venue venue, Long venueID);
    void delete(Long venueID);
}
