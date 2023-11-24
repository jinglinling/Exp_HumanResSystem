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
    public List<User> list() {
        List<User> list = userMapper.listUser();
        return list;
    }
}
