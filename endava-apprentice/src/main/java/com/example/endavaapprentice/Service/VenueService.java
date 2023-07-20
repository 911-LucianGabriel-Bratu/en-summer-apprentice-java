package com.example.endavaapprentice.Service;

import com.example.endavaapprentice.Model.Venue;
import com.example.endavaapprentice.Repository.VenueRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenueService implements IVenueService {
    private VenueRepo venueRepo;

    public VenueService(VenueRepo venueRepo){
        this.venueRepo = venueRepo;
    }

    @Override
    public VenueRepo getVenueRepo(){
        return this.venueRepo;
    }
    @Override
    public Venue fetchOneVenue(Long venueID) {
        return this.venueRepo.findById(venueID).get();
    }

    @Override
    public List<Venue> fetchAllVenues() {
        return (List<Venue>) this.venueRepo.findAll();
    }

    @Override
    public Venue createVenue(Venue venue) {
        return this.venueRepo.save(venue);
    }

    @Override
    public Venue updateVenue(Venue venue, Long venueID) {
        Venue updateVenue = this.venueRepo.findById(venueID).get();
        updateVenue.setLocation(venue.getLocation());
        updateVenue.setType(venue.getType());
        updateVenue.setCapacity(venue.getCapacity());
        return this.venueRepo.save(updateVenue);
    }

    @Override
    public void deleteVenue(Long venueID) {
        this.venueRepo.deleteById(venueID);
    }
}
