package com.example.endavaapprentice.Controller;

import com.example.endavaapprentice.Model.Venue;
import com.example.endavaapprentice.Service.IVenueService;
import com.example.endavaapprentice.Service.VenueServiceIMPL;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VenueController {
    private IVenueService venueService;

    public VenueController(VenueServiceIMPL venueService){
        this.venueService = venueService;
    }

    @GetMapping("/api/venue/{venueID}")
    public Venue fetchOne(@PathVariable("venueID") Long venueID){
        return this.venueService.fetchOne(venueID);
    }

    @GetMapping("/api/venue")
    public List<Venue> fetchAll(){
        return this.venueService.fetchAll();
    }

    @PostMapping("/api/venue")
    public Venue add(@RequestBody Venue venue){
        return this.venueService.add(venue);
    }

    @PutMapping("/api/venue/{venueID}")
    public Venue update(@RequestBody Venue venue, @PathVariable("venueID") Long venueID){
        return this.venueService.update(venue, venueID);
    }
}
