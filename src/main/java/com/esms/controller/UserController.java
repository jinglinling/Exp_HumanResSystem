package com.esms.controller;

import com.esms.entity.User;
import com.esms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/listUser")
    public String listUser(@RequestParam(value = "userID", required = false) Integer userID, Model model) {
        if (userID != null) {//查找指定用户信息
            User user = userService.getUser(userID);
            model.addAttribute("users", Arrays.asList(user));
        } else {//查找所有用户信息
            List<User> users = userService.listUser();
            model.addAttribute("users", users);
        }
        return "userinfo";
    }


    @PostMapping("/addUser")
    public String addUser(User user) {//添加用户信息
        userService.addUser(user);
        return "redirect:/user/listUser";
    }

    @PostMapping("/updateUser")
    public String updateUser(User user) {//修改用户信息
        userService.updateUser(user);
        return "redirect:/user/listUser";
    }

    @PostMapping("/deleteUser")
    public String deleteUser(@RequestParam("userID") int userID) {//删除用户信息
        userService.deleteUser(userID);
        return "redirect:/user/listUser";
    }

    @GetMapping("/addUser")
    public String showAddUserForm() {//显示添加用户界面
        return "addUser";
    }

    @GetMapping("/updateUser")
    public String showUpdateUserForm(@RequestParam("userID") int userID, Model model) {//显示修改用户界面
        User user = userService.getUser(userID);
        model.addAttribute("user", user);
        return "updateUser";
    }

}
