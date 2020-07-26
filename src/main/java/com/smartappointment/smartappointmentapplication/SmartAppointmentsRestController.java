package com.smartappointment.smartappointmentapplication;

import com.smartappointment.smartappointmentapplication.appointment.CheckAcceptanceStatusService;
import com.smartappointment.smartappointmentapplication.car.CarService;
import com.smartappointment.smartappointmentapplication.car.SendCarLocationRequest;
import com.smartappointment.smartappointmentapplication.distance.CheckDistanceService;
import com.smartappointment.smartappointmentapplication.distance.Location;
import com.smartappointment.smartappointmentapplication.user.SendUserLocationRequest;
import com.smartappointment.smartappointmentapplication.user.UserService;
import lombok.var;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SmartAppointmentsRestController {

    private final CheckDistanceService checkDistanceService;
    private final CheckAcceptanceStatusService checkAcceptanceStatusService;
    private final CarService carService;
    private final UserService userService;

    public SmartAppointmentsRestController(CheckDistanceService checkDistanceService, CheckAcceptanceStatusService checkAcceptanceStatusService, CarService carService, UserService userService) {
        this.checkDistanceService = checkDistanceService;
        this.checkAcceptanceStatusService = checkAcceptanceStatusService;
        this.carService = carService;
        this.userService = userService;
    }

    @PatchMapping(path = "/rest/v1/user/{userId}/userlocation", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> processCurrentUserLocation(@PathVariable("userId") Long userId, @RequestBody SendUserLocationRequest userRequest) {
        checkDistanceService.checkDistance(userId, userRequest.getCurrentUserLocation());
        return ResponseEntity.ok().build();
    }

    @PatchMapping(path = "/rest/v1/car/{carId}/carlocation", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> processCurrentCarLocation(@PathVariable("carId") Long carId, @RequestBody SendCarLocationRequest carRequest) {
        checkDistanceService.updateCurrentCarLocation(carId, carRequest);
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/rest/v1/appointment/{appointmentId}/accepted/{accepted}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> processAcceptanceStatus(@PathVariable("appointmentId") Long appointmentId, @PathVariable("accepted") boolean accepted) {
        checkAcceptanceStatusService.updateAcceptanceStatus(appointmentId, accepted);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/rest/v1/car/{carId}/carlocation", produces = MediaType.APPLICATION_JSON_VALUE)
    public Location getCarLocation(@PathVariable("carId") Long carId) {
        var carEntity = carService.getCar(carId);
        return carEntity.getLocation();
    }

    @GetMapping(value = "/rest/v1/user/{userId}/userlocation", produces = MediaType.APPLICATION_JSON_VALUE)
    public Location getUserLocation(@PathVariable("userId") Long userId) {
        var userEntity = userService.getUser(userId);
        return userEntity.getLocation();
    }

    @GetMapping(value = "/rest/v1/appointment/{appointmentId}/appointmentacceptancestatus", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean getAppointmentAcceptanceStatus(@PathVariable("appointmentId") Long appointmentId) {
        var appointmentEntity = checkAcceptanceStatusService.getAppointment(appointmentId);
        return appointmentEntity.isAccepted();
    }

}
