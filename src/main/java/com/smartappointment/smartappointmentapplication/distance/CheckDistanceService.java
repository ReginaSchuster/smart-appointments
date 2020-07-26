package com.smartappointment.smartappointmentapplication.distance;

import com.smartappointment.smartappointmentapplication.car.CarEntity;
import com.smartappointment.smartappointmentapplication.car.CarRepository;
import com.smartappointment.smartappointmentapplication.car.CarService;
import com.smartappointment.smartappointmentapplication.car.SendCarLocationRequest;
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

        var userEntity = userRepository.findByUserId(userId);
        userEntity.setLocation(clientLocation);

        List<CarEntity> cars = carService.getAllCars();
        for (CarEntity car : cars) {
            double distance = distanceCalculator.calculateDistance(clientLocation, car.getLocation());
            if (distance <= 1) {
                AppointmentSuggestionEmail appointmentSuggestionEmail = new AppointmentSuggestionEmail(userEntity.geteMail(), car);
                emailService.sendEmail(appointmentSuggestionEmail);
            }
        }

        return userRepository.save(userEntity);
    }

    @Transactional
    public CarEntity updateCurrentCarLocation(Long carId, SendCarLocationRequest sendCarLocationRequest) {
        var carEntity = carRepository.findByCarId(carId);
        carEntity.setLocation(sendCarLocationRequest.getCurrentCarLocation());
        return carRepository.save(carEntity);
    }
}
