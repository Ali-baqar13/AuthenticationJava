package com.jwt.model;

import com.jwt.configuration.Role;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Entity
@Builder
@AllArgsConstructor

public class User {

    private String firstname;
    private String email;
    private String lastname;
    private String password;
    private Role role;
    
}
