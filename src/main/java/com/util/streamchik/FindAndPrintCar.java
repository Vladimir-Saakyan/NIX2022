package com.util.streamchik;

import com.model.vehicle.Vehicle;
import com.model.vehicle.VehicleType;
import com.repository.AutoRepository;
import com.repository.BusRepiository;
import com.repository.MotoRepository;
import com.service.AutoService;
import com.service.BusService;
import com.service.MotoService;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindAndPrintCar {
    private static final AutoService AUTO_SERVICE = AutoService.getInstanse();
    private static final BusService BUS_SERVICE = BusService.getInstance();
    private static final MotoService MOTO_SERVICE = MotoService.getInstance();
    private static final AutoRepository repoAuto = AutoRepository.getInstance();
    private static final BusRepiository repoBus = BusRepiository.getInstance();
    private static final MotoRepository repoMoto = MotoRepository.getInstance();

    public void getCar() {

    }

    public void statistic(){
        List<Vehicle> cars = createListForStream();
        List<Vehicle> carsPriceToDouble = new ArrayList<Vehicle>();

    }


    private List<Vehicle> createListForStream() {
        final List<Vehicle> vehicleList = new LinkedList<>();
        vehicleList.addAll(repoAuto.getAllCar());
        vehicleList.addAll(repoBus.getAllCar());
        vehicleList.addAll(repoMoto.getAllCar());
        return vehicleList;
    }

    public void addListByDetailsForCar(String id){

    }

    private Map<String, VehicleType> createMap(List<Vehicle> vehicleList){
       return vehicleList.stream().collect(Collectors.toMap(Vehicle::getId, Vehicle::getType));
    }

    public void PrintCarByXPrice() {
        final List<Vehicle> vehicleList = createListForStream();

        vehicleList.stream().forEach(System.out::println);

        System.out.println("---------");

        vehicleList.stream().filter(vehicle -> BigDecimal.valueOf(500).compareTo(vehicle.getPrice()) == 0).collect(Collectors.toList());
        vehicleList.forEach(System.out::println);
    }

    public void sumPrices(){
        final List<Vehicle> vehicleList = createListForStream();
        List<BigDecimal> prices = vehicleList.stream().map(Vehicle::getPrice).toList();

        BigDecimal result = prices.stream().reduce(BigDecimal.valueOf(0), BigDecimal::multiply);
        System.out.println(result);
    }

    public void sortVehicle(){
        final List<Vehicle> vehicleList = createListForStream();

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        final List<Vehicle> result = vehicleList.stream().sorted(Comparator.comparing(Vehicle::getId)).toList();
        result.forEach(System.out::println);
    }

    public void removeDyblic(){
        final List<Vehicle> vehicleList = createListForStream();
        vehicleList.stream().distinct().forEach(System.out::println);
    }

}
