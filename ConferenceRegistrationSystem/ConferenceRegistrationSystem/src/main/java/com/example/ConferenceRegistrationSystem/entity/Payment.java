package com.example.ConferenceRegistrationSystem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Payment {
    @Id
    @GeneratedValue
    private int pid;

   // @JsonIgnore

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "registrationId")
    private Registration registration;
    @Min(value = 1, message = "Amount must be greater than 0")
    private long amount;
    @NotBlank(message = "Payment date cannot be blank")
    private String paymentDate;
}
