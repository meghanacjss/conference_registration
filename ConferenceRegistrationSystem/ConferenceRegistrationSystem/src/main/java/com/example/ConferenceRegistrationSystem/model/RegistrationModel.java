package com.example.ConferenceRegistrationSystem.model;

import com.example.ConferenceRegistrationSystem.entity.Attendee;
import com.example.ConferenceRegistrationSystem.entity.Event;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.util.Date;

public class RegistrationModel {

    private int rid;
  //  @Future(message="enter date must be in future")
    private Date rdate;
  //  @Min(value=1,message="amount must be greater than 1")
    private long ramount;

//    private Attendee attendee;
//    private Event event;

}
