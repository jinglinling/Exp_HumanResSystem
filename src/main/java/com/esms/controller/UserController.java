package com.esms.controller;

import com.esms.entity.User;
import com.esms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/allUser")
    public String list(Model model){
        List<User> list = userService.list();
        return "allUser";
    }
}
