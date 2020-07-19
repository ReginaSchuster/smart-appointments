package com.smartappointment.smartappointmentapplication.car;

import com.smartappointment.smartappointmentapplication.distance.Location;

public class SendCarLocationRequest {

    private Long carId;
    private String model;
    private Location currentCarLocation;

    public SendCarLocationRequest(Long carId, String model, Location currentCarLocation) {
        this.carId = carId;
        this.model = model;
        this.currentCarLocation = currentCarLocation;
    }

    public Long getCarId() {
        return carId;
    }
    public String getModel() { return model; }
    public Location getCurrentCarLocation() {
        return currentCarLocation;
    }
    public void setCarId(Long carId) { this.carId = carId; }
    public void setModel(String model) { this.model = model; }
    public void setCurrentCarLocation(Location currentCarLocation) { this.currentCarLocation = currentCarLocation; }
}
