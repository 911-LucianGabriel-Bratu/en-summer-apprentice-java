package com.example.endavaapprentice.Service;

import com.example.endavaapprentice.Model.Venue;
import com.example.endavaapprentice.Repository.VenueRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenueServiceIMPL implements IVenueService {
    private VenueRepo venueRepo;

    public VenueServiceIMPL(VenueRepo venueRepo){
        this.venueRepo = venueRepo;
    }

    @Override
    public Venue fetchOne(Long venueID) {
        return this.venueRepo.findById(venueID).get();
    }

    @Override
    public List<Venue> fetchAll() {
        return (List<Venue>) this.venueRepo.findAll();
    }

    @Override
    public Venue add(Venue venue) {
        return this.venueRepo.save(venue);
    }

    @Override
    public Venue update(Venue venue, Long venueID) {
        Venue updateVenue = this.venueRepo.findById(venueID).get();
        updateVenue.setLocation(venue.getLocation());
        updateVenue.setType(venue.getType());
        updateVenue.setCapacity(venue.getCapacity());
        return this.venueRepo.save(updateVenue);
    }

    @Override
    public void delete(Long venueID) {
        this.venueRepo.deleteById(venueID);
    }
}
