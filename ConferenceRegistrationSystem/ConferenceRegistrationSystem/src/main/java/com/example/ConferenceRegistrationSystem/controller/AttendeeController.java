package com.example.ConferenceRegistrationSystem.controller;

import com.example.ConferenceRegistrationSystem.entity.Attendee;
import com.example.ConferenceRegistrationSystem.entity.Event;
import com.example.ConferenceRegistrationSystem.exception.UserNotFoundException;
import com.example.ConferenceRegistrationSystem.service.AttendeeService;
import com.example.ConferenceRegistrationSystem.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class AttendeeController {
@Autowired
private AttendeeService attendeeService;
@Autowired
private EventService eventService;

    @PostMapping("/createattendee/")
    public ResponseEntity<Attendee> createAttendee(@RequestBody Attendee attendee, @RequestParam int eid) {
        Event event = eventService.getEventById(eid);
        if (event == null) {
            return ResponseEntity.notFound().build();
        }
        attendee.setEvent(event);
        Attendee createdAttendee = attendeeService.createAttendee(attendee);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAttendee);
    }

    @GetMapping("/allattendees")
    public ResponseEntity<List<Attendee>> getAllAttendees() {
        List<Attendee> attendees = attendeeService.getAllAttendees()
                .stream()
                .collect(Collectors.toList());;
        return ResponseEntity.ok(attendees);
    }

    @GetMapping("/{aid}")
    public ResponseEntity<Attendee> getAttendeeById(@PathVariable int aid) throws UserNotFoundException {
        Optional<Attendee> attendee = attendeeService.getAttendeeById(aid)
                .stream()
                .filter(a -> a.getAid() == aid)
                .findFirst();
        return attendee.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

















//    @PutMapping("/associate/{aid}")
//    public ResponseEntity<Void> associateAttendeeWithEvent(@PathVariable int aid, @RequestParam int eid) {
//        Event event = eventService.getEventById(eid);
//
//        if (event == null) {
//            return ResponseEntity.notFound().build();
//        }
//        attendeeService.associateAttendeeWithEvent(aid, event);
//        return ResponseEntity.ok().build();
//    }
























//    @DeleteMapping("/delete/{aid}")
//
//    public ResponseEntity<String>deleteid(@PathVariable int aid){
//        attendeeService.deleteAttendeeById(aid);
//        return ResponseEntity.status(HttpStatus.CREATED).build();
//    }















//    @PostMapping("/createattendee/{eid}")
//    public Attendee createAttendee(@RequestBody Attendee attendee, @PathVariable int eid) {
//        Event event = eventService.getEventById(eid);
//        attendee.setEvent(event);
//        return attendeeService.createAttendee(attendee);
//    }
//
//    @GetMapping("/allattendees")
//    public List<Attendee> getAllAttendees() {
//        return attendeeService.getAllAttendees();
//    }
//
//    @GetMapping("/{aid}")
//    public Optional<Attendee> getAttendeeById(@PathVariable int aid) {
//        return attendeeService.getAttendeeById(aid);
//    }
//    @PutMapping("/associate/{aid}")
//    public void associateAttendeeWithEvent(@PathVariable int aid, @RequestParam int eid) {
//        Event event = new Event();
//        event.setEid(eid);
//        attendeeService.associateAttendeeWithEvent(aid, event);
//    }
}
