package com.smartappointment.smartappointmentapplication.distance;

import com.smartappointment.smartappointmentapplication.car.CarEntity;
import com.smartappointment.smartappointmentapplication.car.CarRepository;
import com.smartappointment.smartappointmentapplication.car.CarService;
import com.smartappointment.smartappointmentapplication.car.SendCarLocationRequest;
import com.smartappointment.smartappointmentapplication.email.AbstractEmail;
import com.smartappointment.smartappointmentapplication.email.AppointmentSuggestionEmail;
import com.smartappointment.smartappointmentapplication.email.EmailService;
import com.smartappointment.smartappointmentapplication.user.UserEntity;
import com.smartappointment.smartappointmentapplication.user.UserRepository;
import lombok.var;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CheckDistanceService {

    private final CarRepository carRepository;
    private final CarService carService;
    private final DistanceCalculator distanceCalculator;
    private final EmailService emailService;
    private final UserRepository userRepository;

    public CheckDistanceService(CarRepository carRepository, CarService carService, DistanceCalculator distanceCalculator, EmailService emailService, UserRepository userRepository) {
        this.carRepository = carRepository;
        this.carService = carService;
        this.distanceCalculator = distanceCalculator;
        this.emailService = emailService;
        this.userRepository = userRepository;
    }

    public UserEntity checkDistance(Long userId, Location clientLocation) {

        List<CarEntity> cars = carService.getAllCars();
        for (CarEntity car : cars) {
            double distance = distanceCalculator.calculateDistance(clientLocation, car.getLocation());
            if (distance <= 1) {
                AbstractEmail appointmentSuggestionEmail = new AppointmentSuggestionEmail("smartappointment.exampleuser@gmail.com", car);
                emailService.sendEmail(appointmentSuggestionEmail);
            }
        }

        var userEntity = userRepository.findByUserId(userId);
        userEntity.setLocation(clientLocation);
        return userRepository.save(userEntity);
    }

    @Transactional
    public CarEntity updateCurrentCarLocation(Long carId, SendCarLocationRequest sendCarLocationRequest) {
        var carEntity = carRepository.findByCarId(carId);
        carEntity.setLocation(sendCarLocationRequest.getCurrentCarLocation());
        return carRepository.save(carEntity);

//        CarEntity carEntity = CarEntity.builder()
//                    .carId(sendCarLocationRequest.getCarId())
//                    .model(sendCarLocationRequest.getModel())
//                    .location(sendCarLocationRequest.getCurrentCarLocation())
//                    .build();
//        CarEntity savedCarEntity = carRepository.save(carEntity);
//        return savedCarEntity;

    }
}
