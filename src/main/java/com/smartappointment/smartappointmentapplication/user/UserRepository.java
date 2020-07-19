package com.smartappointment.smartappointmentapplication.user;

import com.smartappointment.smartappointmentapplication.car.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByUserId(Long userId);
}
