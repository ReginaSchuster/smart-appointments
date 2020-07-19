package com.smartappointment.smartappointmentapplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class DevelopmentDBInitializer implements ApplicationRunner {

    @PersistenceContext
    private final EntityManager entityManager;

    @Autowired
    public DevelopmentDBInitializer(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void run(ApplicationArguments args) {

        CarEntity car1 = CarEntity.builder()
                .model("VW Golf")
                .location(new Location((long) 1,200.0, 200.0, 0))
                .build();
        entityManager.persist(car1);

        CarEntity car2 = CarEntity.builder()
                .model("Smart")
                .location(new Location((long) 2,150.0, 200.0, 0))
                .build();
        entityManager.persist(car2);

        CarEntity car3 = CarEntity.builder()
                .model("Audi TT")
                .location(new Location((long) 3,100.0, 100.0, 1))
                .build();
        entityManager.persist(car3);

        AppointmentEntity appointment1 = AppointmentEntity.builder()
                .accepted(false)
                .build();
        entityManager.persist(appointment1);

        AppointmentEntity appointment2 = AppointmentEntity.builder()
                .accepted(false)
                .build();
        entityManager.persist(appointment2);
    }
}
