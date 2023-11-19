package com.example.demo.controller;

import com.example.demo.entity.ToDoEntity;
import com.example.demo.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class ToDoController {
    @Autowired
    private ToDoService toDoService;

    @PostMapping
    public ResponseEntity createToDoList(@RequestBody ToDoEntity toDo, @RequestParam Long userId) {
        try {
            return ResponseEntity.ok(toDoService.createToDo(toDo, userId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Виникла помилка!");
        }

    }


    @PutMapping
    public ResponseEntity completedToDo(@RequestParam Long id){
        try{
            return ResponseEntity.ok(toDoService.completeToDo(id));
        }catch (Exception e){
        return ResponseEntity.badRequest().body("Виникла помилка!");
        }

    }

}
