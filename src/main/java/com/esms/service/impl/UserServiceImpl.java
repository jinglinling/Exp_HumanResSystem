package com.esms.service.impl;

import com.esms.entity.User;
import com.esms.mapper.UserMapper;
import com.esms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> listUser() {
        return userMapper.listUser();
    }
    @Override
    public User getUser(int userID) {
        return userMapper.getUser(userID);
    }
    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }
    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }
    @Override
    public void deleteUser(int userID) {
        userMapper.deleteUser(userID);
    }
}
