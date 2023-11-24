package com.example.demo.controller;

import com.example.demo.entity.UserEntity;
import com.example.demo.exception.UserAlreadyExistsException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.badRequest;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping
    public ResponseEntity getOneUser (@RequestParam Long id) {
        try {
           return ResponseEntity.ok(userService.getOneUser(id));
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Виникла помилка");
        }

    }
    @PostMapping
    public ResponseEntity registration(@RequestBody UserEntity user){
        try {
            userService.registration(user);
            return ResponseEntity.ok("Користувача збережено");
            } catch (UserAlreadyExistsException e) {
            return badRequest().body(e.getMessage());
        } catch (Exception e) {
            return badRequest().body("Виникла помилка при збереженні користувача!");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletedUser (@PathVariable Long id){
        try {
            return ResponseEntity.ok(userService.deletedUserById(id));

        } catch (Exception e){
            return ResponseEntity.badRequest().body("Виникла помилка");
        }
    }
    }


