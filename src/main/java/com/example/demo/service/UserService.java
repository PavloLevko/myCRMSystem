package com.example.demo.service;

import com.example.demo.entity.UserEntity;
import com.example.demo.exception.UserAlreadyExistsException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserEntity registration(UserEntity user) throws UserAlreadyExistsException {
            if (userRepository.findByUserName(user.getUserName()) != null) {
                throw new UserAlreadyExistsException("Користувач вже існує!");
            }
            return userRepository.save(user);
    }

    public User getOneUser (Long id) throws UserNotFoundException{
        UserEntity user = userRepository.findById(id).get();
        if(user == null){
          throw new UserNotFoundException("Користувача з таким іменем не знайдено");
        }
        return User.toModel(user);
    }

    public Long deletedUserById(Long id){
     userRepository.deleteById(id);
     return id;
    }

}
