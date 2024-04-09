package org.humber.project.services.impl;

import org.humber.project.domain.Payment;
import org.humber.project.services.PaymentJPAService;
import org.humber.project.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentJPAService paymentJPAService;

    @Autowired
    public PaymentServiceImpl(PaymentJPAService paymentJPAService) {
        this.paymentJPAService = paymentJPAService;
    }

    @Override
    public Payment createPayment(Payment payment) {
        return paymentJPAService.save(payment);
    }

    @Override
    public boolean deletePayment(Long paymentId) {
        return paymentJPAService.deleteById(paymentId);
    }

    @Override
    public Payment updatePayment(Payment payment) {
        return paymentJPAService.save(payment);
    }

    @Override
    public Payment getPayment(Long paymentId) {
        return paymentJPAService.findById(paymentId)
                .orElseThrow(() -> new RuntimeException("Payment not found with ID: " + paymentId));
    }
}
