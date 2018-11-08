package com.wng.jenkin.security.service;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    public ResponseEntity<?> login(String username, String paswword) {

        return null;
    }

    public ResponseEntity<?> logout(String tokey) {
        return null;
    }

    public ResponseEntity<?> signup() {
        return null;
    }




}
