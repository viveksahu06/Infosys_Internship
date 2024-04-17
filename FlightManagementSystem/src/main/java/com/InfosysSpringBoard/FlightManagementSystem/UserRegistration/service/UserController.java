package com.InfosysSpringBoard.FlightManagementSystem.UserRegistration.service;

import com.InfosysSpringBoard.FlightManagementSystem.UserRegistration.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequiredArgsConstructor
@RequestMapping("/users")

public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User>getUsers(){
        return userService.getUsers();
    }

}
