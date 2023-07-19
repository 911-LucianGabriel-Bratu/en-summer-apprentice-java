package com.example.endavaapprentice.Repository;

import com.example.endavaapprentice.Model.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepo extends CrudRepository<Event, Long> {
}
