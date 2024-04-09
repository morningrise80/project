package org.humber.project.transformers;

import org.humber.project.domain.Orders;
import org.humber.project.domain.Payment;
import org.humber.project.repositories.entities.PaymentEntity;

import java.util.List;
import java.util.stream.Collectors;

public final class PaymentEntityTransformer {

    private PaymentEntityTransformer() {
    }

    public static Payment transformToPayment(PaymentEntity paymentEntity) {
        if (paymentEntity != null) {
            Orders order = paymentEntity.getOrder();
            if (order != null) {
                return new Payment(paymentEntity.getPaymentId(), order, paymentEntity.getPaymentType());
            }
        }
        return null; // Handle null case if needed
    }

    public static PaymentEntity transformToPaymentEntity(Payment payment) {
        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.setPaymentId(payment.getPaymentId());
        // Assuming the order is directly set in Payment
        paymentEntity.setOrder(payment.getOrder());
        paymentEntity.setPaymentType(payment.getPaymentType());
        return paymentEntity;
    }

    public static List<Payment> transformToPayments(List<PaymentEntity> paymentEntities) {
        return paymentEntities.stream()
                .map(PaymentEntityTransformer::transformToPayment)
                .collect(Collectors.toList());
    }

    public static List<PaymentEntity> transformToPaymentEntities(List<Payment> payments) {
        return payments.stream()
                .map(PaymentEntityTransformer::transformToPaymentEntity)
                .collect(Collectors.toList());
    }
}
