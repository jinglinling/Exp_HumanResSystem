package com.esms.service;

import com.esms.entity.User;

import java.util.List;

public interface UserService {
    List<User> listUser();
    User getUser(int userID);
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(int userID);
}
