package com.command;

import com.service.AutoService;
import com.service.BusService;
import com.service.MotoService;
import com.service.Service;

public class PrintAll implements Command{
    private static final AutoService AUTO_SERVICE = AutoService.getInstanse();
    private static final BusService BUS_SERVICE = BusService.getInstance();
    private static final MotoService MOTO_SERVICE = MotoService.getInstance();
    @Override
    public void execute() {
        AUTO_SERVICE.printAll();
        BUS_SERVICE.printAll();
        MOTO_SERVICE.printAll();
    }
}
