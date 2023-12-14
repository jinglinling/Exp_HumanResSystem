package com.esms.test;

import com.esms.entity.User;
import com.esms.mapper.UserMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class UserTest {
    @Test
    public void listUserTest(){//查找所有用户
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        UserMapper userMapper = context.getBean(UserMapper.class);
        List<User> listUser = userMapper.listUser();
        for (User user : listUser) {
            System.out.println(user);
        }
    }

    @Test
    public void getUserTest(){//根据ID查找用户
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        UserMapper userMapper = context.getBean(UserMapper.class);
        User user = userMapper.getUser(1);
        System.out.println(user);
    }

    @Test
    public void addUserTest() {//添加用户
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        UserMapper userMapper = context.getBean(UserMapper.class);
        User user = new User(3,"202111701132","王五","123456",1);
        userMapper.addUser(user);
    }

    @Test
    public void updateUserTest() {//更改用户
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        UserMapper userMapper = context.getBean(UserMapper.class);
        User user = userMapper.getUser(3);
        user.setUserName("赵六");
        user.setUserPassword("114514");
        userMapper.updateUser(user);
    }

    @Test
    public void deleteUserTest() {//删除用户
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        UserMapper userMapper = context.getBean(UserMapper.class);
        userMapper.deleteUser(3);
    }
}
