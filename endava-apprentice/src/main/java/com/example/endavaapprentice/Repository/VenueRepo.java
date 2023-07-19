package com.example.endavaapprentice.Repository;

import com.example.endavaapprentice.Model.Venue;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VenueRepo extends CrudRepository<Venue, Long> {
}
