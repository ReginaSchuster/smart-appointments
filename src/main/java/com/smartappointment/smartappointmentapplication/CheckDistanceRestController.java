package com.smartappointment.smartappointmentapplication;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckDistanceRestController {

    private final CheckDistanceService checkDistanceService;

    public CheckDistanceRestController(CheckDistanceService checkDistanceService) {
        this.checkDistanceService = checkDistanceService;
    }

    @PostMapping(path = "/rest/v1/userlocation", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> processCurrentUserLocation(@RequestBody SendUserLocationRequest userRequest) {
        checkDistanceService.checkDistance(userRequest.getClientId(), userRequest.getCurrentUserLocation());
        return ResponseEntity.ok().build();
    }

    @PostMapping(path = "/rest/v1/carlocation", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> processCurrentCarLocation(@RequestBody SendCarLocationRequest carRequest) {
        checkDistanceService.addCarToFleet(carRequest);
        return ResponseEntity.ok().build();
    }

}
