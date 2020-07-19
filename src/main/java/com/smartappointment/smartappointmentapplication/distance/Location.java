package com.smartappointment.smartappointmentapplication.distance;

import lombok.Builder;

import javax.persistence.*;

@Entity(name = "location")
@Table(name = "location")
public class Location {

    @Id
    @Column
    private Long locationId;

    @Column(nullable = true, name = "latitude")
    private Double latitude;

    @Column(nullable = true, name = "longitude")
    private Double longitude;

    @Column(nullable = true, name = "direction")
    private int direction;


    /*@OneToOne
    @PrimaryKeyJoinColumn
    private CarEntity carEntity;*/

    public Location(){}

    @Builder
    public Location(Long locationId, Double latitude, Double longitude, int direction) {
        this.locationId = locationId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.direction = direction;
    }

    public Long getLocationId() {
        return locationId;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public int getDirection() {
        return direction;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "Location{" +
                "locationId=" + locationId +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", direction=" + direction +
                '}';
    }
}
