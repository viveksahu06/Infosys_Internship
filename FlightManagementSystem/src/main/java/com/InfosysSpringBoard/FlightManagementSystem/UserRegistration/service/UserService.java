package com.InfosysSpringBoard.FlightManagementSystem.UserRegistration.service;

import com.InfosysSpringBoard.FlightManagementSystem.UserRegistration.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User>getUsers();
    User registerUser(RegistrationRequest request);
    Optional<User>findByEmail(String Email);
}