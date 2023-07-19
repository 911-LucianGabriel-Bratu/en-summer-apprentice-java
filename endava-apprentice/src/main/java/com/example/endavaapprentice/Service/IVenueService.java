package com.example.endavaapprentice.Service;

import com.example.endavaapprentice.Model.Venue;
import com.example.endavaapprentice.Repository.VenueRepo;

import java.util.List;

public interface IVenueService {
    VenueRepo getVenueRepo();
    Venue fetchOneVenue(Long venueID);
    List<Venue> fetchAllVenues();
    Venue createVenue(Venue venue);
    Venue updateVenue(Venue venue, Long venueID);
    void deleteVenue(Long venueID);
}
