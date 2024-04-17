package com.InfosysSpringBoard.FlightManagementSystem.UserRegistration.service;

import com.InfosysSpringBoard.FlightManagementSystem.UserRegistration.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);


}
