package com.smartappointment.smartappointmentapplication;

import lombok.var;
import org.springframework.stereotype.Service;

@Service
public class CheckAcceptanceStatusService {

    private final AppointmentRepository appointmentRepository;

    public CheckAcceptanceStatusService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public AppointmentEntity updateAcceptanceStatus (Long appointmentId, boolean accepted) {
        var appointmentEntity= appointmentRepository.findByAppointmentId(appointmentId);
        if (appointmentEntity.isPresent()) {
            var appointmentEntityToUpdate = appointmentEntity.get();
            appointmentEntityToUpdate.setAccepted(true);

            return appointmentRepository.save(appointmentEntityToUpdate);
        }
        else {
            return null;
        }
    }
}
