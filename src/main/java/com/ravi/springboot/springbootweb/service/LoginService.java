package com.ravi.springboot.springbootweb.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
    public boolean validateUser(String username, String password) {
        return "ravi".equalsIgnoreCase(username) && "teja".equalsIgnoreCase(password);
    }
}
