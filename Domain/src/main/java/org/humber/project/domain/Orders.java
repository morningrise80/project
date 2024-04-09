package org.humber.project.domain;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table (name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double price;
    private Long trackingId; // DeliveryTracking.java
    private Long paymentId; // Payment.java

    public Orders(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Column(columnDefinition = "TEXT")
    private String imageFile;

    public Orders() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImageFile() {
        return imageFile;
    }

    public void setImageFile(String imageFile) {
        this.imageFile = imageFile;
    }
}
