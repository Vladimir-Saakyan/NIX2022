package com.service;

import com.model.Auto;
import com.model.Manufacturer;
import com.repository.AutoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.Supplier;

import static com.model.Manufacturer.KIA;

public class AutoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AutoService.class);
    private static final Random RANDOM = new Random();
    private final AutoRepository autoRepository;


    public AutoService(AutoRepository autoRepository) {
        this.autoRepository = autoRepository;
    }

    public List<Auto> createAndSaveAutos(int count) {
        List<Auto> result = new LinkedList<>();
        for (int i = 0; i < count; i++) {
            final Auto auto = new Auto(
                    "Model-" + RANDOM.nextInt(1000),
                    getRandomManufacturer(),
                    BigDecimal.valueOf(RANDOM.nextDouble(1000.0)),
                    "Model-" + RANDOM.nextInt(1000)
            );
            result.add(auto);
            autoRepository.createCar(auto);
            LOGGER.debug("Created auto {}", auto.getId());
        }
        return result;
    }

    private Manufacturer getRandomManufacturer() {
        final Manufacturer[] values = Manufacturer.values();
        final int index = RANDOM.nextInt(values.length);
        return values[index];
    }

    public void saveAutos(List<Auto> autos) {
        autoRepository.createAllCar(autos);
    }

    public void printAll() {
        for (Auto auto : autoRepository.getAllCar()) {
            System.out.println(auto);
        }
    }

    public Optional<Auto> findOneById(String id) {
        Optional.of(autoRepository.getByIdCar(id)).ifPresent(auto -> auto.getId());
        System.out.println(id);
        return Optional.empty();
    }

    public Optional<Auto> findAllPrice(String id){
        Auto result = Optional.of(autoRepository.getPrice(id)).map(auto->autoRepository.getByIdCar(id))
                .orElseThrow(()->new IllegalArgumentException("cannot find"));
        return Optional.ofNullable(result);
    }

    public Auto update(Auto auto) {
        autoRepository.updateCar(auto);
        return auto;
    }

    public void delete(String id) {
        autoRepository.deleteCar(id);
        System.out.println(id);
    }

//    public void filterPrice(String id){
//        List<Auto> result = Optional.of(autoRepository.getPrice(id))
//                .filter(values -> autoRepository.getPrice(id) > 0)
//                .orElseThrow(new IllegalArgumentException("invalid price"));
//    }
    public Optional<Auto> findAutos(String id){
        Optional.of(autoRepository.getByIdCar(id))
                .ifPresentOrElse(auto -> auto.getId()
                ,(() -> System.out.println("auto is empty")));
        return Optional.empty();
    }

    public Optional<Auto> findPriceForId(String id) {
        Optional.of(autoRepository.getPrice(id)).orElse(BigDecimal.ONE);
        System.out.println(autoRepository.getPrice(id));
        return Optional.ofNullable(null);
    }

    public Optional<Auto> findAuto(String id) {
        Optional.of(autoRepository.getByIdCar(id)).orElseGet(() ->
                new Auto("qwerty",
                        KIA,
                        BigDecimal.ZERO,
                        "qwerty"));
        System.out.println(autoRepository.getByIdCar(id));
        return Optional.empty();
    }

    public void findManufactureById(String id) {
        try {
            Optional.of(autoRepository.getManufactureById(id)).
                    orElseThrow(() -> new IllegalArgumentException("Cannot find auto" + id));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
//    public void findMethod(String id) {
//        final Optional<Auto> met = autoRepository.getManufactureById(id).or(()->Optional.of(defaultAuto()));
//        met.ifPresent(auto -> System.out.println(auto.getModel()));
//    }


    private Auto defaultAuto(){
        return new Auto(
                "qwerty",
                getRandomManufacturer(),
                BigDecimal.ZERO,
                "model - " + RANDOM.nextLong(100)) ;
    }
}
