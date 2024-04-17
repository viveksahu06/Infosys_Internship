//package com.InfosysSpringBoard.FlightManagementSystem.UserRegistration.registration;
//
//import com.InfosysSpringBoard.FlightManagementSystem.UserRegistration.User;
//import com.InfosysSpringBoard.FlightManagementSystem.UserRegistration.event.RegistrationCompleteEvent;
//import com.InfosysSpringBoard.FlightManagementSystem.UserRegistration.service.UserService;
//import jakarta.servlet.http.HttpServletRequest;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.ApplicationEventPublisher;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/register")
//public class RegistationController {
//    private final UserService userService;
//    private final ApplicationEventPublisher publisher;
//
//    public RegistationController(UserService userService, ApplicationEventPublisher publisher) {
//        this.userService = userService;
//        this.publisher = publisher;
//    }
//    @PostMapping
//    public String registerUser(RegistrationRequest registrationRequest, final HttpServletRequest request){
//        User user=userService.registerUser(registrationRequest);
//        //event publish registration event
//        publisher.publishEvent(new RegistrationCompleteEvent(user,applicationUrl(request)));
//        return "Successfully registered ! please, check your email to complete registration";
//    }
//
//    private String applicationUrl(HttpServletRequest request) {
//        return "http://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
//    }
//}
package com.InfosysSpringBoard.FlightManagementSystem.UserRegistration.registration;

import com.InfosysSpringBoard.FlightManagementSystem.UserRegistration.User;
import com.InfosysSpringBoard.FlightManagementSystem.UserRegistration.event.RegistrationCompleteEvent;
import com.InfosysSpringBoard.FlightManagementSystem.UserRegistration.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequiredArgsConstructor
@RequestMapping("/register")
public class RegistationController {
    private final UserService userService;
    private final ApplicationEventPublisher publisher;

    public RegistationController(UserService userService, ApplicationEventPublisher publisher) {
        this.userService = userService;
        this.publisher = publisher;
    }

    @PostMapping
    public String registerUser(RegistrationRequest registrationRequest, final HttpServletRequest request){
        User user=userService.registerUser(registrationRequest);
        publisher.publishEvent(new RegistrationCompleteEvent(user,applicationUrl(request)));
        return "Successfully registered ! please, check your email to complete registration";
    }

    private String applicationUrl(HttpServletRequest request) {
        return "http://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
    }
}

