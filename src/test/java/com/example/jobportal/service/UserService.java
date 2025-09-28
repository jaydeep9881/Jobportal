package com.example.jobportal.service;

import com.example.jobportal.model.Users;
import com.example.jobportal.repositary.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UserService {
    @Autowired
    UserRepo repo;
    private BCryptPasswordEncoder encoder= new BCryptPasswordEncoder(12);
    public Users addUser(Users user) {
        user.setPassword(encoder.encode(user.getPassword()));
        Users save = repo.save(user);
        return save;
    }
}
