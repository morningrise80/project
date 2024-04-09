package org.humber.project.services;

import org.humber.project.domain.Payment;

import java.util.Optional;

public interface PaymentJPAService {
    Payment save(Payment payment);

    boolean deleteById(Long paymentId);

    Optional<Payment> findById(Long paymentId);
}
