package com.InfosysSpringBoard.FlightManagementSystem.UserRegistration.registration;

import java.math.BigInteger;

public record RegistrationRequest(
        Long id,String firstName,String lastName,String email, String password,BigInteger mobileNo,String role
) {

}
