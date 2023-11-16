package com.example.demo.Controller;

import com.example.demo.Entity.UserEntity;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.badRequest;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping
    public ResponseEntity getUsers() {
        try {
           return ResponseEntity.ok("Сервер працює");
        } catch (Exception e) {
            return badRequest().body("Виникла помилка");
        }
    }

    @PostMapping
    public ResponseEntity registration(@RequestBody UserEntity user){
        try {
            if(userRepository.findByUserName(user.getUserName()) != null){
                return ResponseEntity.badRequest().body("Користувач з іменем: " + user.getUserName() + " вже існує!" );
            }
            userRepository.save(user);
            return ResponseEntity.ok("Користувача збережено");
        } catch (Exception e) {
            return badRequest().body("Виникла помилка при збереженні користувача!");
        }
    }
    }


