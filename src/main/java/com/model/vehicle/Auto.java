package com.model.vehicle;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Auto extends Vehicle {
    private String bodyType;
    private List<String> details;

    public Auto(String model, Manufacturer manufacturer,
                BigDecimal price, String bodyType, int number, String date,
                List<String> details) {
        super(model, manufacturer, price,number, date, VehicleType.AUTO);

        this.bodyType = bodyType;
        this.details = details;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "details=" + details +
                ", id='" + id + '\'' +
                ", model='" + model + '\'' +
                ", numberRest=" + numberRest +
                ", price=" + price +
                ", manufacturer=" + manufacturer +
                ", date='" + date + '\'' +
                ", type=" + type +
                '}';
    }

}
