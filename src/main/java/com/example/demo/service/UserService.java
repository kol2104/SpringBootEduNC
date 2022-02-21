package com.example.demo.service;

import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUserById(int id) {
        return userRepository.findById(id).get();
    }

    public User createUser(User newUser) {
        return userRepository.save(newUser);
    }

    public User updateUserById(int id, User user) {
        userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        user.setId(id);
        userRepository.updateUser(user.getId(), user.getName(), user.getLastName(), user.getMobile());
        return user;
    }

    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }

    public List<User> getUsersByName(String name) {
        return userRepository.findByName(name);
    }
}
