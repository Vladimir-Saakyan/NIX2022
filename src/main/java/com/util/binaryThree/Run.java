package com.util.binaryThree;

import com.command.Command;
import com.service.AutoService;
import com.service.BusService;
import com.service.MotoService;

public class Run implements Command {
    final ThreeBin three = new ThreeBin();
    private static final AutoService AUTO_SERVICE = AutoService.getInstanse();
    private static final BusService BUS_SERVICE = BusService.getInstance();
    private static final MotoService MOTO_SERVICE = MotoService.getInstance();

    @Override
    public void execute() {
        three.createNode(558);

        three.printTree();

    }
}
