package org.humber.project.services.impl;

import org.humber.project.domain.Payment;
import org.humber.project.repositories.PaymentJPARepository;
import org.humber.project.repositories.entities.PaymentEntity;
import org.humber.project.services.PaymentJPAService;
import org.humber.project.transformers.PaymentEntityTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentJPAServiceImpl implements PaymentJPAService {

    private final PaymentJPARepository paymentJPARepository;

    @Autowired
    public PaymentJPAServiceImpl(PaymentJPARepository paymentJPARepository) {
        this.paymentJPARepository = paymentJPARepository;
    }

    @Override
    public Payment save(Payment payment) {
        PaymentEntity paymentEntity = paymentJPARepository.save(PaymentEntityTransformer.transformToPaymentEntity(payment));
        return PaymentEntityTransformer.transformToPayment(paymentEntity);
    }

    @Override
    public boolean deleteById(Long paymentId) {
        Optional<Payment> payment = this.findById(paymentId);
        if (payment.isPresent()) {
            paymentJPARepository.deleteById(paymentId);
            return true;
        }
        return false;
    }

    @Override
    public Optional<Payment> findById(Long paymentId) {
        return paymentJPARepository.findById(paymentId).map(PaymentEntityTransformer::transformToPayment);
    }
}
