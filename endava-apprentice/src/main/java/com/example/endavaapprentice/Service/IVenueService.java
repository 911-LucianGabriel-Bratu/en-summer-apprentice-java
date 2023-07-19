package com.example.endavaapprentice.Service;

import com.example.endavaapprentice.Model.Venue;

import java.util.List;

public interface IVenueService {
    Venue fetchOneVenue(Long venueID);
    List<Venue> fetchAllVenues();
    Venue createVenue(Venue venue);
    Venue updateVenue(Venue venue, Long venueID);
    void deleteVenue(Long venueID);
}
