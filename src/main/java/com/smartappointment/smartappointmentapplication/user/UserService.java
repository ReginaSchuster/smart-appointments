package com.smartappointment.smartappointmentapplication.user;

import com.smartappointment.smartappointmentapplication.car.CarEntity;
import com.smartappointment.smartappointmentapplication.car.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public UserEntity getUser(Long userId) {
        return userRepository.findByUserId(userId);
    }
}
