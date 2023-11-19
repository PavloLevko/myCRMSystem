package com.example.demo.model;

import com.example.demo.entity.ToDoEntity;
import com.example.demo.entity.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

public class User {
    private Long id;
    private int telephoneNumber;
    private String userName;
    private String email;
    private List<ToDo> toDoList;

    //model return User param without password!
    public static User toModel (UserEntity entity){
        User model = new User();
        model.setId(entity.getId());
        model.setUserName(entity.getUserName());
        model.setTelephoneNumber (entity.getTelephoneNumber());
        model.setEmail(entity.getEmail());
        model.setToDoList(entity.getToDo().stream().map(ToDo::toModel).collect(Collectors.toList()));
        return model;
    }

    public User() {
    }

    public List<ToDo> getToDoList() {
        return toDoList;
    }

    public void setToDoList(List<ToDo> toDoList) {
        this.toDoList = toDoList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public int getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(int telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
