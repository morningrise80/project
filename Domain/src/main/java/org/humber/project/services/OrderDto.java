package org.humber.project.services;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

@Getter
public class OrderDto {

    @NotEmpty(message = "this field CANNOT be empty")
    private String name;

    @Min(0)
    private double price;

    private MultipartFile imageFile;

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setImageFile(MultipartFile imageFile) {
        this.imageFile = imageFile;
    }
}
