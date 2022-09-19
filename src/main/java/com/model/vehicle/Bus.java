package com.model.vehicle;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalTime;

@Setter
@Getter

public class Bus extends Vehicle {
    private String bodytype;

    public Bus(String model, Manufacturer manufacturer, BigDecimal price, String bodytype, int number, LocalTime date) {
        super(model, manufacturer, price, number, date);
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
                ", restailing num - " + numberRest+
                ", date created :" + date+
                '}';
    }
}
