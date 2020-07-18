package com.smartappointment.smartappointmentapplication;

public class SendUserLocationRequest {

    private Location currentUserLocation;
    private Long clientId;

    public SendUserLocationRequest(Location currentUserLocation, Long clientId) {
        this.currentUserLocation = currentUserLocation;
        this.clientId = clientId;
    }

    public Location getCurrentUserLocation() {
        return currentUserLocation;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setCurrentUserLocation(Location currentUserLocation) {
        this.currentUserLocation = currentUserLocation;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }
}
