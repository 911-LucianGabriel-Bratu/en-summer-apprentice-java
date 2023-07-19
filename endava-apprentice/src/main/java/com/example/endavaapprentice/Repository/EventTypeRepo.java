package com.example.endavaapprentice.Repository;

import com.example.endavaapprentice.Model.EventType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventTypeRepo extends CrudRepository<EventType, Long> {
}
