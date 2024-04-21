package com.InfosysSpringBoard.FlightManagementSystem.UserRegistration.registration;


import java.math.BigInteger;

public record RegistrationRequest(
        Long id, String fullName, String email, String password, String mobileNo, String role
) {

}
