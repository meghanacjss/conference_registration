package com.example.ConferenceRegistrationSystem.repository;

import com.example.ConferenceRegistrationSystem.entity.Attendee;
import com.example.ConferenceRegistrationSystem.entity.Event;
import com.example.ConferenceRegistrationSystem.entity.Registration;
import com.example.ConferenceRegistrationSystem.model.RegistrationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration,Integer> {

  //  List<Registration> findByEvent(Event event);

  //  List<Registration> findByAttendee(Attendee attendee);
}
