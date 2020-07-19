package com.smartappointment.smartappointmentapplication.car;

import com.smartappointment.smartappointmentapplication.appointment.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Long> {

    CarEntity findByCarId(Long carId);
}
