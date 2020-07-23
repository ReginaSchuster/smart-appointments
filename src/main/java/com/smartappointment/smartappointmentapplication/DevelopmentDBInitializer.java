package com.smartappointment.smartappointmentapplication;

import com.smartappointment.smartappointmentapplication.appointment.AppointmentEntity;
import com.smartappointment.smartappointmentapplication.car.CarEntity;
import com.smartappointment.smartappointmentapplication.distance.Location;
import com.smartappointment.smartappointmentapplication.user.UserEntity;
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

        // CARS ----------------------------------------------------------------------------------------
        CarEntity car1 = CarEntity.builder()
                .model("mBot Experiment Car")
                .doors(0)
                .seats(0)
                .babySeats("No baby-seats available.")
                .carBoot("No car boot")
                .selfDriving(true)
                .rating(0.0)
                .location(new Location((long) 1,150.0, 200.0, 0))
                .build();
        entityManager.persist(car1);

        CarEntity car2 = CarEntity.builder()
                .model("VW Golf")
                .doors(5)
                .seats(5)
                .babySeats("No baby-seats available.")
                .carBoot("Big-sized car boot")
                .selfDriving(false)
                .rating(4.5)
                .location(new Location((long) 2,500.0, 600.0, 0))
                .build();
        entityManager.persist(car2);

        CarEntity car3 = CarEntity.builder()
                .model("Smart")
                .doors(3)
                .seats(5)
                .babySeats("One baby-seat available (age 3-5).")
                .carBoot("Small-sized car boot")
                .selfDriving(false)
                .rating(5.0)
                .location(new Location((long) 3,300.0, 350.0, 0))
                .build();
        entityManager.persist(car3);

        CarEntity car4 = CarEntity.builder()
                .model("Audi TT")
                .doors(5)
                .seats(5)
                .babySeats("Two baby-seats available (age 0-2 and age 3-5).")
                .carBoot("Medium-sized car boot")
                .selfDriving(false)
                .rating(3.0)
                .location(new Location((long) 4,300.0, 400.0, 0))
                .build();
        entityManager.persist(car4);

        CarEntity car5 = CarEntity.builder()
                .model("BMW 3")
                .doors(5)
                .seats(5)
                .babySeats("One baby-seat available (age 0-2).")
                .carBoot("Medium-sized car boot")
                .selfDriving(false)
                .rating(4.7)
                .location(new Location((long) 5,250.0, 300.0, 0))
                .build();
        entityManager.persist(car5);

        CarEntity car6 = CarEntity.builder()
                .model("Fiat Punto")
                .doors(3)
                .seats(5)
                .babySeats("No baby-seats available.")
                .carBoot("Small-sized car boot")
                .selfDriving(false)
                .rating(3.9)
                .location(new Location((long) 6,450.0, 500.0, 0))
                .build();
        entityManager.persist(car6);

        // USERS ----------------------------------------------------------------------------------------
        UserEntity user1 = UserEntity.builder()
                .firstName("Example")
                .lastName("User")
                .eMail("smartappointment.exampleuser@gmail.com")
                .dateOfRegistry("20.07.2020")
                .dateOfBirth("18.09.1992")
                .location(new Location((long) 11,110.0, 120.0, 0))
                .build();
        entityManager.persist(user1);

        UserEntity user2 = UserEntity.builder()
                .firstName("Regina")
                .lastName("Schuster")
                .eMail("regina_schuster@gmx.de")
                .dateOfRegistry("20.07.2020")
                .dateOfBirth("13.05.1992")
                .location(new Location((long) 12,450.0, 550.0, 0))
                .build();
        entityManager.persist(user2);

        UserEntity user3 = UserEntity.builder()
                .firstName("Carina")
                .lastName("Urbanke")
                .eMail("carina_urbanke@gmx.de")
                .dateOfRegistry("20.07.2020")
                .dateOfBirth("27.07.1994")
                .location(new Location((long) 13,350.0, 500.0, 0))
                .build();
        entityManager.persist(user3);

        UserEntity user4 = UserEntity.builder()
                .firstName("Gabi")
                .lastName("Müller")
                .eMail("gabi-müller@gmx.de")
                .dateOfRegistry("20.07.2020")
                .dateOfBirth("07.06.1984")
                .location(new Location((long) 14,500.0, 600.0, 0))
                .build();
        entityManager.persist(user4);

        UserEntity user5 = UserEntity.builder()
                .firstName("Hans")
                .lastName("Lebschi")
                .eMail("hansilebschi@gmail.com")
                .dateOfRegistry("20.07.2020")
                .dateOfBirth("13.02.1955")
                .location(new Location((long) 15,280.0, 350.0, 0))
                .build();
        entityManager.persist(user5);

        UserEntity user6 = UserEntity.builder()
                .firstName("Simon")
                .lastName("Berber")
                .eMail("simon-berber@gmail.com")
                .dateOfRegistry("20.07.2020")
                .dateOfBirth("07.02.1980")
                .location(new Location((long) 16,300.0, 550.0, 0))
                .build();
        entityManager.persist(user6);

        // APPOINTMENTS ----------------------------------------------------------------------------------------
        AppointmentEntity appointment1 = AppointmentEntity.builder()
                .accepted(false)
                .userPickup(true)
                .date("26.07.2020")
                .time("14:00")
                .userEntity(1)
                .carEntity(1)
                .build();
        entityManager.persist(appointment1);

    }
}
