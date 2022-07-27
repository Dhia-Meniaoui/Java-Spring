package com.Dhia;


import org.springframework.stereotype.Component;

@Component
public class Scren {
    private String brand;


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Scren{" +
                "brand='" + brand + '\'' +
                '}';
    }
}
