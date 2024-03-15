package com.example.ConferenceRegistrationSystem.model;

import com.example.ConferenceRegistrationSystem.entity.Registration;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PaymentModel {

    private int pid;
   // @Min(value = 1, message = "Amount must be greater than 0")
    private long amount;
   // @NotBlank(message = "Payment date cannot be blank")
    private String paymentDate;

//private Registration registration;
}
