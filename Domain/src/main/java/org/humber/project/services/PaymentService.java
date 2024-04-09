package org.humber.project.services;

import org.humber.project.domain.Payment;

public interface PaymentService {
    Payment createPayment(Payment payment);

    boolean deletePayment(Long paymentId);

    Payment updatePayment(Payment payment);

    Payment getPayment(Long paymentId);
}
