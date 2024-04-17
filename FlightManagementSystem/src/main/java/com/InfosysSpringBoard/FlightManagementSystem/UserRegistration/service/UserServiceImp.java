package com.InfosysSpringBoard.FlightManagementSystem.UserRegistration.service;

import com.InfosysSpringBoard.FlightManagementSystem.UserRegistration.User;
import com.InfosysSpringBoard.FlightManagementSystem.UserRegistration.exception.UserAlreadyExistsException;
import com.InfosysSpringBoard.FlightManagementSystem.UserRegistration.registration.RegistrationRequest;
import com.InfosysSpringBoard.FlightManagementSystem.UserRegistration.registration.token.VerificationToken;
import com.InfosysSpringBoard.FlightManagementSystem.UserRegistration.registration.token.VerificationTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;
@Service
//@RequiredArgsConstructor
public class UserServiceImp implements UserService {
     private final UserRepository userRepository;
     private final PasswordEncoder passwordEncoder ;
     private final VerificationTokenRepository tokenRepository;

    public UserServiceImp(UserRepository userRepository, PasswordEncoder passwordEncoder, VerificationTokenRepository tokenRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenRepository = tokenRepository;
    }


    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User registerUser(RegistrationRequest request) {
        Optional<User>user=this.findByEmail(request.email());
        if(user.isPresent()){
            throw new UserAlreadyExistsException("User with email"+request.email()+"already exists");
        }
        var newUser=new User();
        newUser.setFirstName(request.firstName());
        newUser.setLastName(request.lastName());
        newUser.setEmail(request.email());
        newUser.setPassword(passwordEncoder.encode(request.password()));
        newUser.setRole(request.role());

        return userRepository.save(newUser);


      //  newUser.setfi(request.firstName());


    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    @Override
    public void saveUserVerificationToken(User theUser, String token) {
        var verificationToken = new VerificationToken(token, theUser);
        tokenRepository.save(verificationToken);
    }

    @Override
    public String validateToken(String theToken) {
        VerificationToken token = tokenRepository.findByToken(theToken);
        if(token == null){
            return "Invalid verification token";
        }
        User user = token.getUser();
        Calendar calendar = Calendar.getInstance();
        if ((token.getExpirationTime().getTime() - calendar.getTime().getTime()) <= 0){
            tokenRepository.delete(token);
            return "Token already expired";
        }
        user.setEnabled(true);
        userRepository.save(user);
        return "valid";
    }
}
