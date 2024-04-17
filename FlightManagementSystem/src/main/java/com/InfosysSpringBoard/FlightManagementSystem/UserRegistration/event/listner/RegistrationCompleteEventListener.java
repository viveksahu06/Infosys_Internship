package com.InfosysSpringBoard.FlightManagementSystem.UserRegistration.event.listner;

import com.InfosysSpringBoard.FlightManagementSystem.UserRegistration.User;
import com.InfosysSpringBoard.FlightManagementSystem.UserRegistration.service.UserService;
import com.InfosysSpringBoard.FlightManagementSystem.UserRegistration.event.RegistrationCompleteEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Slf4j
@Component
//@RequiredArgsConstructor
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {
    private final UserService userService;
    private static final Logger log = LoggerFactory.getLogger(RegistrationCompleteEventListener.class);

    public RegistrationCompleteEventListener(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        User theUser = event.getUser();
        String verificationToken = java.util.UUID.randomUUID().toString();
        userService.saveUserVerificationToken(theUser, verificationToken);
        String url = event.getApplicationUrl() + "/register/verifyEmail?token=" + verificationToken;
        log.info("Click the link to verify your registration :  {}", url);
    }
}
