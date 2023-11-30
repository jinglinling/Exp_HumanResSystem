package com.esms.mapper;

import com.esms.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    List<User> listUser();
    User getUser(int userID);
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(int userID);
}
