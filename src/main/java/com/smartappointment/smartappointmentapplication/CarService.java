package com.smartappointment.smartappointmentapplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<CarEntity> getAllCars() {
        return carRepository.findAll();
    }

    /*public List<CarEntity> findAllCars() {
        List<CarEntity> cars = new ArrayList<>();
        cars.add(new CarEntity(UUID.randomUUID(), "VW Golf", new Location(200.0, 200.0)));
        cars.add(new CarEntity(UUID.randomUUID(), "Smart", new Location(150.0, 200.0)));
        cars.add(new CarEntity(UUID.randomUUID(), "Audi TT", new Location(100.0, 100.0)));

        return cars;
    }*/
}
