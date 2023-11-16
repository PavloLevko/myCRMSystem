package com.example.demo.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @GetMapping
    public ResponseEntity getUsers() {
        try {
           return ResponseEntity.ok("Сервер працює");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Виникла помилка");
        }
    }
}

