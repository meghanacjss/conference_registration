package com.example.ConferenceRegistrationSystem.repository;

import com.example.ConferenceRegistrationSystem.entity.Event;
import com.example.ConferenceRegistrationSystem.model.EventModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event,Integer> {
}
