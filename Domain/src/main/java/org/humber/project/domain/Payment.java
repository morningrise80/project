package org.humber.project.domain;

import lombok.Data;

@Data
public class Payment {
    private Long paymentId;
    private Orders order;
    private String paymentType; // CREDIT, DEBIT, GIFT CARD

    public Payment(Long paymentId, Orders order, String paymentType) {
        this.paymentId = paymentId;
        this.order = order;
        this.paymentType = paymentType;
    }

    public double getOrderAmount() {
        if (order != null) {
            return order.getPrice();
        }
        return 0.0; 
    }
}
