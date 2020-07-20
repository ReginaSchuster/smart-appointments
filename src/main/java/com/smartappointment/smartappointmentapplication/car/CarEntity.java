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

    @Column(name = "doors", nullable = true)
    private int doors;

    @Column(name = "seats", nullable = true)
    private int seats;

    @Column(name = "baby_seats", nullable = true)
    private String babySeats;

    @Column(name = "car_boot", nullable = true)
    private String carBoot;

    @Column(name = "self_driving", nullable = true)
    private boolean selfDriving;

    @Column(name = "rating", nullable = true)
    private double rating;

    @OneToOne(cascade = CascadeType.ALL)
    private Location location;

    @Builder
    public CarEntity(Long carId, String model, int doors, int seats, String babySeats, String carBoot, boolean selfDriving, double rating, Location location) {
        this.carId = carId;
        this.model = model;
        this.doors = doors;
        this.seats = seats;
        this.babySeats = babySeats;
        this.carBoot = carBoot;
        this.selfDriving = selfDriving;
        this.rating = rating;
        this.location = location;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getBabySeats() {
        return babySeats;
    }

    public void setBabySeats(String babySeats) {
        this.babySeats = babySeats;
    }

    public String getCarBoot() {
        return carBoot;
    }

    public void setCarBoot(String carBoot) {
        this.carBoot = carBoot;
    }

    public boolean isSelfDriving() {
        return selfDriving;
    }

    public void setSelfDriving(boolean selfDriving) {
        this.selfDriving = selfDriving;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "CarEntity{" +
                "carId=" + carId +
                ", model='" + model + '\'' +
                ", doors='" + doors + '\'' +
                ", seats='" + seats + '\'' +
                ", baby-seats='" + babySeats + '\'' +
                ", car-boot='" + carBoot + '\'' +
                ", self-driving='" + selfDriving + '\'' +
                ", rating='" + rating + '\'' +
                ", location=" + location +
                '}';
    }
}
