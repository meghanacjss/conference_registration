package com.example.ConferenceRegistrationSystem.service;

import com.example.ConferenceRegistrationSystem.entity.Payment;
import com.example.ConferenceRegistrationSystem.entity.Registration;
import com.example.ConferenceRegistrationSystem.repository.PaymentRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment createPayment(@Valid Payment payment) {
        return paymentRepository.save(payment);
    }
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll().stream()

                .filter(payment -> payment.getAmount() > 100)
                .sorted(Comparator.comparing(Payment::getPaymentDate))
                .collect(Collectors.toList());
    }
    public List<Payment> getPaymentsByRegistration(Registration registration) {
        List<Payment> getPayment = paymentRepository.findByRegistration(registration);
        return getPayment.stream()
                .filter(payment->payment.getRegistration().equals(registration))
                .collect(Collectors.toList());

      //  return paymentRepository.findByRegistration(registration);
    }
    public long calculateTotalPayments(Registration registration) {
        List<Payment> payments = paymentRepository.findByRegistration(registration);
//        long totalPayments = 0;
//        for (Payment payment : payments) {
//            totalPayments += payment.getAmount();
//        }
//
//        return totalPayments;

        return payments.stream().mapToLong(Payment::getAmount).sum();
    }

    public void cancelPayment(int pid) {
        Optional<Payment> optionalPayment = paymentRepository.findById(pid);
        if (optionalPayment.isPresent()) {
            Payment payment = optionalPayment.get();
            if (canCancelPayment(payment)) {
                payment.setAmount(0);
                paymentRepository.save(payment);
            } else {
                throw new IllegalStateException("Payment cannot be canceled.");
            }
        } else {
            throw new IllegalArgumentException("Payment not found.");
        }
    }

    private boolean canCancelPayment(Payment payment) {

        return payment.getAmount()>0;
    }
}
