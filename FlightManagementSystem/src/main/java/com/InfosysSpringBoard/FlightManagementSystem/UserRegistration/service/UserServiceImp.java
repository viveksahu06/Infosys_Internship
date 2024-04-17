package com.InfosysSpringBoard.FlightManagementSystem.UserRegistration.service;

import com.InfosysSpringBoard.FlightManagementSystem.UserRegistration.User;
import com.InfosysSpringBoard.FlightManagementSystem.UserRegistration.registration.RegistrationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {
     private final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User registerUser(RegistrationRequest request) {
        Optional<User>user=this.findByEmail(request.email());
        if(user.isPresent()){
           // throw new UserAlreadyExistsException("User with email"+request.email()+"already exists");
        }
        var newUser=new User();
        newUser.setFirstName(request.firstName());
        newUser.setLastName(request.lastName());
        newUser.setEmail(request.email());
        newUser.setPassword(request.password());
        newUser.setRole(request.role());

        return userRepository.save(newUser);


      //  newUser.setfi(request.firstName());


    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
