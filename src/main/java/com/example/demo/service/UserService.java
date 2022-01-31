package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.profile.request.UserProfileRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    private final List<User> userList = new ArrayList<>(
            Arrays.asList(
                    new User(1, "Ivan", "Ivanov", "123456"),
                    new User(2, "Sergey", "Sergeev", "987654"),
                    new User(3, "Dmitry", "Dmitriev", "456123")
            )
    );

    public List<User> getUsers() {
        return userList;
    }

    public User getUserById(int id) {
        return userList.stream().filter(user -> user.getId() == id).findFirst().get();
    }

    public User createUser(User newUser) {
        User lastUser = userList.isEmpty() ? null : userList.get(userList.size() - 1);
        if (lastUser != null) {
            newUser.setId(lastUser.getId() + 1);
        } else {
            newUser.setId(1);
        }
        userList.add(newUser);
        return newUser;
    }

    public void updateUserById(int id, UserProfileRequest userProfileRequest) {
        User newUser = userList.stream().filter(user -> user.getId() == id).findFirst().get();
        newUser.setName(userProfileRequest.getName());
        newUser.setLastName(userProfileRequest.getLastName());
        newUser.setMobile(userProfileRequest.getMobile());
    }

    public void deleteUserById(int id) {
        userList.remove(id - 1);
        int num = 1;
        for (User u : userList) {
            u.setId(num++);
        }
    }
}
