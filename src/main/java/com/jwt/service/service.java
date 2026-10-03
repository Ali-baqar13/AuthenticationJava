package com.jwt.service;

import org.springframework.stereotype.Service;

import com.jwt.model.AuthenticationRequest;
import com.jwt.model.AuthenticationResponse;
import com.jwt.model.User;

@Service 
public class service {
    public AuthenticationResponse registerUser(User users){

        User user = new User.builder()
        .firstname(users.getFirstname())
        .lastname(users.getLastname())
        .email(users.getEmail())
        .role(users.getRole())
        .password(passwordEncoder.encoded(users.getPassword()))
        .build();

        var token = jwtService.generateToken(user);
        return AuthenticationResponse().builder().token(token).build();
        ;


    }
    
}
