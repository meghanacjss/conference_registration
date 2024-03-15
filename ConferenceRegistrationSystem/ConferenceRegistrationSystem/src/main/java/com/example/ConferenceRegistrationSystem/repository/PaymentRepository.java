package com.example.ConferenceRegistrationSystem.repository;

import com.example.ConferenceRegistrationSystem.entity.Payment;
import com.example.ConferenceRegistrationSystem.entity.Registration;
import com.example.ConferenceRegistrationSystem.model.PaymentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Integer> {
    List<Payment> findByRegistration(Registration registration);
}
