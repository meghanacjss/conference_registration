package com.example.ConferenceRegistrationSystem.service;

import com.example.ConferenceRegistrationSystem.entity.Attendee;
import com.example.ConferenceRegistrationSystem.entity.Event;
import com.example.ConferenceRegistrationSystem.entity.Registration;
import com.example.ConferenceRegistrationSystem.repository.RegistrationRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;
    public Registration createRegistration(@Valid Event event, Attendee attendee, Date registrationDate, long registrationAmount) {
        Registration registration = new Registration();
        registration.setEvent(event);
        attendee.setEvent(event);
        registration.setAttendee(attendee);
        registration.setRdate(registrationDate);
        registration.setRamount(registrationAmount);
        return registrationRepository.save(registration);
    }

    public List<Registration> getAllRegistrations() {
        return registrationRepository.findAll().stream()
                .sorted(Comparator.comparing(Registration::getRdate))
                .collect(Collectors.toList());
    }

    public List<Registration> getRegistrationsByEvent(Event event) {
       List<Registration> all = registrationRepository.findAll();
       return all.stream()
               .filter(registration ->registration.getEvent().getEid() == event.getEid())
              // .filter(registration ->registration.getEvent().equals(event))
               .collect(Collectors.toList());
       // return registrationRepository.findByEvent(event);
    }

    public List<Registration> getRegistrationsByAttendee(Attendee attendee) {

        List<Registration> allRegistrations = registrationRepository.findAll();

        return allRegistrations.stream()
                .filter(registration -> registration.getAttendee().getAid() == attendee.getAid())
                .collect(Collectors.toList());
    }
      // return registrationRepository.findByAttendee(attendee);
    public Registration getRegistrationById(int rid) {
        return registrationRepository.findAll()
                .stream()
                .filter(registration -> registration.getRid() == rid)
                .findFirst()
                .orElse(null);

       // return registrationRepository.findById(rid).orElse(null);
    }

    public void cancelRegistration(int rid) {
        Registration registration = getRegistrationById(rid);
        if (registration != null) {
            if (canCancelRegistration(registration)) {
                registrationRepository.delete(registration);
            } else {
                throw new IllegalStateException("Registration cannot be canceled.");
            }
        } else {
            throw new IllegalArgumentException("Registration not found.");
        }
    }

    private boolean canCancelRegistration(Registration registration) {
        return registration.getRdate().after(new Date());
    }

}






//    public String  deleteRegistrationById(int rid) {
//        if (registrationRepository.existsById(rid)) {
//            registrationRepository.deleteById(rid);
//        }
//        return "deleted id";
//    }
