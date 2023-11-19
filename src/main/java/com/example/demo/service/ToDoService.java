package com.example.demo.service;

import com.example.demo.entity.ToDoEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.model.ToDo;
import com.example.demo.repository.ToDoRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoService {
    @Autowired
    private ToDoRepository toDoRepository;
    @Autowired
    private UserRepository userRepository;
    public ToDo createToDo(ToDoEntity toDo, Long userId){
        UserEntity user = userRepository.findById(userId).get();
        toDo.setUser(user);
        return ToDo.toModel(toDoRepository.save(toDo));
    }
    public ToDo completeToDo(Long id){
        ToDoEntity toDo = toDoRepository.findById(id).get();
        toDo.setCompleted(!toDo.isCompleted());
        return ToDo.toModel(toDoRepository.save(toDo));
    }
}
