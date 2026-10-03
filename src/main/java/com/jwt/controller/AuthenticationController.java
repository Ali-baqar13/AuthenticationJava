package com.jwt.controller;

import org.springframework.web.bind.annotation.RestController;

import com.jwt.model.AuthenticationRequest;
import com.jwt.model.AuthenticationResponse;
import com.jwt.service.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController 
@RequestMapping("/auth")
public class AuthenticationController {

    @PostMapping("/api/v1/register")
    public ResponseEntity<AuthenticationResponse> Register(AuthenticationRequest req){
        return new ResponseEntity<>(service.registerUser(req));
        
    }
    
}
