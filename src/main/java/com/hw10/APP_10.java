package com.hw10;

import com.hw10.model.Auto;
import com.hw10.model.Moto;
import com.hw10.model.Vehicle;
import com.hw10.repository.AutoRepository;
import com.hw10.service.AutoService;
import com.hw10.model.Bus;
import com.hw10.service.BusService;
import com.hw10.service.MotoService;

import java.util.List;


public class APP_10 {
    private static final AutoService AUTO_SERVICE = new AutoService();
    private static final BusService BUS_SERVICE = new BusService();
    private static final MotoService MOTO_SERVICE = new MotoService();

    public static void app() {

        System.out.println("                                                                 ===AUTO===");

        final List<Auto> autos = AUTO_SERVICE.createAutos(5);
        Auto auto = autos.get(0);
        AUTO_SERVICE.saveAutos(autos);
        AUTO_SERVICE.printAll();
        AUTO_SERVICE.update(auto);
        AUTO_SERVICE.delete(auto.getId());
        System.out.println("- - - - - - -  after remove auto  - - - - - - - - ");
        AUTO_SERVICE.printAll();

        System.out.println("                                                                 ===BUS===");

        final List<Bus> buses = BUS_SERVICE.createBuses(2);
        Bus bus = buses.get(0);
        BUS_SERVICE.saveBuses(buses);
        BUS_SERVICE.printAllBus();
        BUS_SERVICE.updateBus(bus);
        BUS_SERVICE.deleteBus(bus.getId());
        System.out.println("- - - - - - -  after remove bus  - - - - - - - - ");
        BUS_SERVICE.printAllBus();

        System.out.println("                                                                 ===MOTO===");

        final List<Moto> motos = MOTO_SERVICE.createMoto(5);
        Moto moto = motos.get(0);
        MOTO_SERVICE.saveMoto(motos);
        MOTO_SERVICE.printAllMotos();
        MOTO_SERVICE.updateMoto(moto);
        MOTO_SERVICE.deleteMoto(moto.getId());
        System.out.println("- - - - - - -  after remove moto  - - - - - - - - ");
    }
}
