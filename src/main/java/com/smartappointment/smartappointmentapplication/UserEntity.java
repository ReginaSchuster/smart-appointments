package com.smartappointment.smartappointmentapplication;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "user")
@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE) // for hibernate and model mapper
public class UserEntity {

    @Id
    @Column(name = "id", nullable = false)
    private Long clientId;
}
