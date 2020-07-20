package com.smartappointment.smartappointmentapplication.appointment;

import com.smartappointment.smartappointmentapplication.car.CarEntity;
import com.smartappointment.smartappointmentapplication.distance.Location;
import com.smartappointment.smartappointmentapplication.user.UserEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "appointments")
@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE) // for hibernate and model mapper
public class AppointmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentId;

    @Column(name = "accepted", nullable = false)
    private boolean accepted;

    @Column(name = "user_pickup", nullable = false)
    private boolean userPickup;

    @Column(name = "date", nullable = false)
    private String date;

    @Column(name = "time", nullable = false)
    private String time;

    @Column(name = "user_id", nullable = false)
    private int userEntity;

    @Column(name = "car_id", nullable = false)
    private int carEntity;

    @Builder
    public AppointmentEntity(Long appointmentId, boolean accepted, boolean userPickup, String date, String time, int userEntity, int carEntity) {
        this.appointmentId = appointmentId;
        this.accepted = accepted;
        this.userPickup = userPickup;
        this.date = date;
        this.time = time;
        this.userEntity = userEntity;
        this.carEntity = carEntity;
    }

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public boolean isUserPickup() {
        return userPickup;
    }

    public void setUserPickup(boolean userPickup) {
        this.userPickup = userPickup;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(int userEntity) {
        this.userEntity = userEntity;
    }

    public int getCarEntity() {
        return carEntity;
    }

    public void setCarEntity(int carEntity) {
        this.carEntity = carEntity;
    }
}
