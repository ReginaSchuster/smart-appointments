package com.smartappointment.smartappointmentapplication.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public CarEntity getCar(Long carId) {
        return carRepository.findByCarId(carId);
    }

    /*public List<CarEntity> findAllCars() {
        List<CarEntity> cars = new ArrayList<>();
        cars.add(new CarEntity(UUID.randomUUID(), "VW Golf", new Location(200.0, 200.0)));
        cars.add(new CarEntity(UUID.randomUUID(), "Smart", new Location(150.0, 200.0)));
        cars.add(new CarEntity(UUID.randomUUID(), "Audi TT", new Location(100.0, 100.0)));

        return cars;
    }*/
}
