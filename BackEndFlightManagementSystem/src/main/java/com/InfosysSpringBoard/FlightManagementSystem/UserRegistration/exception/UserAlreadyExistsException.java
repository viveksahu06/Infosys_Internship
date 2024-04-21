package com.InfosysSpringBoard.FlightManagementSystem.UserRegistration.exception;

public class UserAlreadyExistsException extends RuntimeException
{
    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
