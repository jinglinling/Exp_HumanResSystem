package com.esms.mapper;

import com.esms.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    List<User> listUser();
}
