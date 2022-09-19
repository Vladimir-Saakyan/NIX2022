package com.model.vehicle;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalTime;

@Getter
@Setter
public class Auto extends Vehicle {
    private String bodyType;

    public Auto(String model, Manufacturer manufacturer, BigDecimal price, String bodyType, int number, LocalTime date) {
        super(model, manufacturer, price,number, date);
        this.bodyType = bodyType;
    }

    @Override
    public String toString() {
        return "Auto{" +
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
