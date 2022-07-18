package com.hw10.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter

public class Moto extends Vehicle{
    private String bodyType;

    public Moto(String model, Manufacturer manufacturer, BigDecimal price, String bodyType) {
        super(model, manufacturer, price);
        this.bodyType = bodyType;
    }

    @Override
    public String toString() {
        return "Moto{" +
                "bodyType='" + bodyType + '\'' +
                ", id='" + id + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", manufacturer=" + manufacturer +
                '}';
    }
}
