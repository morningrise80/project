package org.humber.project.domain;

import jakarta.persistence.*;
import lombok.*;


@Setter
@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double price;

    @Column(columnDefinition = "TEXT")
    private String imageFileName;

}
