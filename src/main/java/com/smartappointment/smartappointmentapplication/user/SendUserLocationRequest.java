package com.smartappointment.smartappointmentapplication.user;

import com.smartappointment.smartappointmentapplication.distance.Location;

public class SendUserLocationRequest {

    private Location currentUserLocation;
    private Long userId;

    public SendUserLocationRequest(Location currentUserLocation, Long userId) {
        this.currentUserLocation = currentUserLocation;
        this.userId = userId;
    }

    public Location getCurrentUserLocation() {
        return currentUserLocation;
    }

    public Long getUserId() {
        return userId;
    }

    public void setCurrentUserLocation(Location currentUserLocation) {
        this.currentUserLocation = currentUserLocation;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
