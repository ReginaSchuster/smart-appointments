package com.smartappointment.smartappointmentapplication.user;

import com.smartappointment.smartappointmentapplication.distance.Location;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "users")
@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE) // for hibernate and model mapper
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "e_mail")
    private String eMail;

    @Column(name = "date_of_registry")
    private String dateOfRegistry;

    @Column(name = "date_of_birth")
    private String dateOfBirth;

    @OneToOne(cascade = CascadeType.ALL)
    private Location location;

    @Builder
    public UserEntity(Long userId, String firstName, String lastName, String eMail, String dateOfRegistry, String dateOfBirth, Location location) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMail = eMail;
        this.dateOfRegistry = dateOfRegistry;
        this.dateOfBirth = dateOfBirth;
        this.location = location;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getDateOfRegistry() {
        return dateOfRegistry;
    }

    public void setDateOfRegistry(String dateOfRegistry) {
        this.dateOfRegistry = dateOfRegistry;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
