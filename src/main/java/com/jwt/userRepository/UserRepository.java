package com.jwt.userRepository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.jwt.model.User;

@Component 
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);
    
}
