package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class UserEntity {
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
        private int telephoneNumber;
        private String userName;
        private String email;
        private String password;
        @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
        private List<ToDoEntity> toDo;

    public UserEntity() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(int telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String name) {
        this.userName = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<ToDoEntity> getToDo() {
        return toDo;
    }

    public void setToDo(List<ToDoEntity> toDo) {
        this.toDo = toDo;
    }
}
