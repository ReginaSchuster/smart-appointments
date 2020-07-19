package com.smartappointment.smartappointmentapplication.appointment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Long> {

    //Optional<AppointmentEntity> findByAppointmentId(Long appointmentId);
    AppointmentEntity findByAppointmentId(Long appointmentId);
}
