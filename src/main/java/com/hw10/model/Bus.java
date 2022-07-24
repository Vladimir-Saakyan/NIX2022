package com.hw10.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter

public class Bus extends Vehicle {
    private String bodytype;

    public Bus(String model, Manufacturer manufacturer, BigDecimal price, String bodytype) {
        super(model, manufacturer, price);
        this.bodytype = bodytype;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "bodytype='" + bodytype + '\'' +
                ", id='" + id + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", manufacturer=" + manufacturer +
                '}';
    }
}
