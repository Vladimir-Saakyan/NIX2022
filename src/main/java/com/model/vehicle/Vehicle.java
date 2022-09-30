package com.model.vehicle;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Getter
@Setter
public abstract class Vehicle {
    protected final String id;
    protected String model;
    protected int numberRest;
    protected BigDecimal price;
    protected Manufacturer manufacturer;
    protected String date;
    protected VehicleType type;

    protected Vehicle(String model, Manufacturer manufacturer, BigDecimal price, int numberRest, String date, VehicleType type) {
        this.id = UUID.randomUUID().toString();
        this.model = model;
        this.manufacturer = manufacturer;
        this.price = price;
        this.numberRest= numberRest;
        this.date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:MM:SS"));
        this.type = type;
    }
}
