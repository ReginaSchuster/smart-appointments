package com.smartappointment.smartappointmentapplication;

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

    /*@OneToOne
    @PrimaryKeyJoinColumn
    private CarEntity carEntity;*/

    public Location(){}

    @Builder
    public Location(Long locationId, Double latitude, Double longitude) {
        this.locationId = locationId;
        this.latitude = latitude;
        this.longitude = longitude;
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

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Location{" +
                "locationId=" + locationId +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
