package com.smartappointment.smartappointmentapplication.appointment;

import com.smartappointment.smartappointmentapplication.car.CarEntity;
import lombok.var;
import org.springframework.stereotype.Service;

@Service
public class CheckAcceptanceStatusService {

    private final AppointmentRepository appointmentRepository;

    public CheckAcceptanceStatusService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public AppointmentEntity getAppointment(Long appointmentId) {
        return appointmentRepository.findByAppointmentId(appointmentId);
    }

    public AppointmentEntity updateAcceptanceStatus (Long appointmentId, boolean accepted) {
        var appointmentEntity = appointmentRepository.findByAppointmentId(appointmentId);
        appointmentEntity.setAccepted(accepted);
        return appointmentRepository.save(appointmentEntity);

    }

}
