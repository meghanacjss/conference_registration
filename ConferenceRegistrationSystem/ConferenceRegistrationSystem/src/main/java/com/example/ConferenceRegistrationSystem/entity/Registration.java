package com.example.ConferenceRegistrationSystem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Registration {
    @Id
    @GeneratedValue
    private int rid;

  // @JsonIgnore

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "eventId")
    private Event event;

   // @JsonIgnore

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "attendeeId")
    private Attendee attendee;
    @Future(message="enter date must be in future")
    private Date rdate;
    @Min(value=1,message="amount must be greater than 1")
    private long ramount;

}
