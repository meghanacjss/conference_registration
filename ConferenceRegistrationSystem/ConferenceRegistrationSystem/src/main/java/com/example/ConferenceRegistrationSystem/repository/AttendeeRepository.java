package com.example.ConferenceRegistrationSystem.repository;

import com.example.ConferenceRegistrationSystem.entity.Attendee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendeeRepository extends JpaRepository<Attendee,Integer> {
}
