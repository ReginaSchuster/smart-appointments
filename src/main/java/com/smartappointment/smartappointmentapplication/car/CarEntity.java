package com.smartappointment.smartappointmentapplication.car;

import com.smartappointment.smartappointmentapplication.distance.Location;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "cars")
@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE) // for hibernate and model mapper
public class CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carId;

    @Column(name = "model", nullable = false)
    private String model;

    @OneToOne(cascade = CascadeType.ALL)
    private Location location;

    @Builder
    public CarEntity(Long carId, String model, Location location) {
        this.carId = carId;
        this.model = model;
        this.location = location;
    }

    public Long getCarId() {
        return carId;
    }

    public String getModel() {
        return model;
    }

    public Location getLocation() {
        return location;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "CarEntity{" +
                "carId=" + carId +
                ", model='" + model + '\'' +
                ", location=" + location +
                '}';
    }
}
