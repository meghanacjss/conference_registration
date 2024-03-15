package com.example.ConferenceRegistrationSystem.controller;
import com.example.ConferenceRegistrationSystem.entity.Attendee;
import com.example.ConferenceRegistrationSystem.entity.Event;
import com.example.ConferenceRegistrationSystem.entity.Registration;
import com.example.ConferenceRegistrationSystem.service.EventService;
import com.example.ConferenceRegistrationSystem.service.RegistrationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;

@RestController
public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;
    @Autowired
    private EventService eventService;
    @PostMapping("/createall")
    public Registration createRegistration(@RequestBody @Valid Registration registration) {
    //    System.out.println(registration.getAttendee());
        Event event = registration.getEvent();
        Attendee attendee = registration.getAttendee();
        Date registrationDate = registration.getRdate();
        long registrationAmount = registration.getRamount();
        return registrationService.createRegistration(event, attendee, registrationDate, registrationAmount);
    }
    @GetMapping("/getall")
    public List<Registration> getAllRegistrations() {
        return registrationService.getAllRegistrations().stream().toList();
    }
    @GetMapping("/byEvent/")
    public List<Registration> getRegistrationsByEvent(@RequestParam int eid) {
        Event event = new Event();
        event.setEid(eid);
        return registrationService.getRegistrationsByEvent(event);
    }
    @GetMapping("/byAttendee/")
    public List<Registration> getRegistrationsByAttendee(@RequestParam int aid) {
        Attendee attendee = new Attendee();
        attendee.setAid(aid);
        return registrationService.getRegistrationsByAttendee(attendee);
    }

    @DeleteMapping("/cancel/{rid}")
    public ResponseEntity<String> cancelRegistration(@PathVariable int rid) {
        try {
            registrationService.cancelRegistration(rid);
            return new ResponseEntity<>("Registration canceled successfully.", HttpStatus.OK);
        } catch (IllegalStateException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }












//    @DeleteMapping("/deletedbyid/{rid}")
//    public String deleteRegistration(@PathVariable int rid) {
//        registrationService.deleteRegistrationById(rid);
//        return "id deleted";
//    }














    /* @PostMapping("/createevent")
    public ResponseEntity<Registration> createRegistration(@RequestBody @Valid Registration registration) {
        Event event = registration.getEvent();
        Attendee attendee = registration.getAttendee();
        Date registrationDate = registration.getRdate();
        long registrationAmount = registration.getRamount();

        Registration createdRegistration = registrationService.createRegistration(event, attendee, registrationDate, registrationAmount);

        return new ResponseEntity<>(createdRegistration, HttpStatus.CREATED);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Registration>> getAllRegistrations() {
        List<Registration> registrations = registrationService.getAllRegistrations();
        return new ResponseEntity<>(registrations, HttpStatus.OK);
    }

    @GetMapping("/byEvent/{eid}")
    public ResponseEntity<List<Registration>> getRegistrationsByEvent(@PathVariable int eid) {
        Event event = new Event();
        event.setEid(eid);

        List<Registration> registrations = registrationService.getRegistrationsByEvent(event);
        return new ResponseEntity<>(registrations, HttpStatus.OK);
    }

    @GetMapping("/byAttendee/{aid}")
    public ResponseEntity<List<Registration>> getRegistrationsByAttendee(@PathVariable int aid) {
        Attendee attendee = new Attendee();
        attendee.setAid(aid);

        List<Registration> registrations = registrationService.getRegistrationsByAttendee(attendee);
        return new ResponseEntity<>(registrations, HttpStatus.OK);
    }*/
}
