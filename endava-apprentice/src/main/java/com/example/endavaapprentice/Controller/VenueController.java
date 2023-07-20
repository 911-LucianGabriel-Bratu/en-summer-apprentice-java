package com.example.endavaapprentice.Controller;

import com.example.endavaapprentice.Model.Venue;
import com.example.endavaapprentice.Service.IVenueService;
import com.example.endavaapprentice.Service.VenueService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/venue")
public class VenueController {
    private IVenueService venueService;

    public VenueController(VenueService venueService){
        this.venueService = venueService;
    }

    @GetMapping("/{venueID}")
    public Venue fetchOneVenue(@PathVariable("venueID") Long venueID){
        return this.venueService.fetchOneVenue(venueID);
    }

    @GetMapping
    public List<Venue> fetchAllVenues(){
        return this.venueService.fetchAllVenues();
    }

    @PostMapping
    public Venue createVenue(@RequestBody Venue venue){
        return this.venueService.createVenue(venue);
    }

    @PutMapping("/{venueID}")
    public Venue updateVenue(@RequestBody Venue venue, @PathVariable("venueID") Long venueID){
        return this.venueService.updateVenue(venue, venueID);
    }

    @DeleteMapping("/{venueID}")
    public void deleteVenue(@PathVariable("venueID") Long venueID){
        this.venueService.deleteVenue(venueID);
    }
}
