package com;

import com.model.vehicle.Auto;
import com.model.vehicle.Bus;
import com.model.vehicle.Moto;
import com.model.vehicle.Vehicle;
import com.repository.AutoRepository;
import com.repository.BusRepiository;
import com.repository.MotoRepository;
import com.service.AutoService;
import com.service.BusService;
import com.service.MotoService;
import com.util.Container;
import com.util.Garage;
import com.util.LinkList;

import java.util.List;

public class Main {
    private static final AutoService AUTO_SERVICE = new AutoService(new AutoRepository());
    private static final BusService BUS_SERVICE = new BusService(new BusRepiository());
    private static final MotoService MOTO_SERVICE = new MotoService(new MotoRepository());
    private static Container container = new Container();
    private static Garage<Vehicle> garage = new Garage<Vehicle>();


    public static void main(String[] args) {

        System.out.println("- - - - - - -  hw13  - - - - - - - - ");
        container.prinall();
        container.discount();
        container.dPrice();

        System.out.println("- - - - - - -  hw14  - - - - - - - - ");
        final Garage<Vehicle> vehicleList = new Garage<>();
        final List<Auto > autos = AUTO_SERVICE.createAndSaveAutos(5);
        final List<Bus> buses = BUS_SERVICE.createAndSaveAutos(2);
        final List<Moto> motos = MOTO_SERVICE.createAndSaveAutos(5);
        for(Auto vehicle: autos){
            vehicleList.add(vehicle);
        }
        System.out.println("add auto, return size of Garage : "+ vehicleList.size());
        for(Bus vehicle: buses){
            vehicleList.add(vehicle);
        }
        System.out.println("add bus, return size of Garage : "+vehicleList.size());
        for(Moto vehicle: motos){
            vehicleList.add(vehicle);
        }
        System.out.println("add moto, return size of Garage : "+vehicleList.size());

    }


}