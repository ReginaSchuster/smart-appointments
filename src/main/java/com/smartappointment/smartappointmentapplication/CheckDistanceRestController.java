package com.smartappointment.smartappointmentapplication;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CheckDistanceRestController {

    private final CheckDistanceService checkDistanceService;
    private final CheckAcceptanceStatusService checkAcceptanceStatusService;

    public CheckDistanceRestController(CheckDistanceService checkDistanceService, CheckAcceptanceStatusService checkAcceptanceStatusService) {
        this.checkDistanceService = checkDistanceService;
        this.checkAcceptanceStatusService = checkAcceptanceStatusService;
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

    @PutMapping(path = "/rest/v1/appointment/{appointmentId}/accepted/{accepted}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> processAcceptanceStatus(@PathVariable("appointmentId") Long appointmentId, @PathVariable("accepted") boolean accepted) {
        checkAcceptanceStatusService.updateAcceptanceStatus(appointmentId, accepted);
        return ResponseEntity.ok().build();
    }

}
