package org.humber.project.repositories.entities;

import org.humber.project.domain.Orders;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "payment")
@Entity
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Long paymentId;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Orders order;

    @Column(name = "order_amount") 
    private double orderAmount; 

    @Column(name = "payment_type")
    private String paymentType;

}
