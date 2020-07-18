package com.smartappointment.smartappointmentapplication;

import com.smartappointment.smartappointmentapplication.email.AbstractEmail;
import com.smartappointment.smartappointmentapplication.email.AppointmentSuggestionEmail;
import com.smartappointment.smartappointmentapplication.email.EmailService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CheckDistanceService {

    private final CarRepository carRepository;
    private final CarService carService;
    private final DistanceCalculator distanceCalculator;
    private final EmailService emailService;

    public CheckDistanceService(CarRepository carRepository, CarService carService, DistanceCalculator distanceCalculator, EmailService emailService) {
        this.carRepository = carRepository;
        this.carService = carService;
        this.distanceCalculator = distanceCalculator;
        this.emailService = emailService;
    }

    public void checkDistance(Long clientId, Location clientLocation) {
        List<CarEntity> cars = carService.getAllCars();
        for (CarEntity car : cars) {
            double distance = distanceCalculator.calculateDistance(clientLocation, car.getLocation());
            if (distance <= 1) {
                AbstractEmail appointmentSuggestionEmail = new AppointmentSuggestionEmail("regina_schuster@gmx.de", car);
                emailService.sendEmail(appointmentSuggestionEmail);
            }
        }
    }

    @Transactional
    public CarEntity addCarToFleet(SendCarLocationRequest sendCarLocationRequest) {
        CarEntity carEntity = CarEntity.builder()
                    .carId(sendCarLocationRequest.getCarId())
                    .model(sendCarLocationRequest.getModel())
                    .location(sendCarLocationRequest.getCurrentCarLocation())
                    .build();
        CarEntity savedCarEntity = carRepository.save(carEntity);
        return savedCarEntity;

    }
}
