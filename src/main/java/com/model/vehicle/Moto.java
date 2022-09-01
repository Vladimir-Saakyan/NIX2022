package com.model.vehicle;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter

public class Moto extends Vehicle {
    private String bodyType;

    public Moto(String model, Manufacturer manufacturer, BigDecimal price, String bodyType, int number, String date) {
        super(model, manufacturer, price, number,date, VehicleType.MOTO);
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
                ", restailing num - " + numberRest+
                ", date created :" + date+
                '}';
    }
}
