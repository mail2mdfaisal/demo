package com.kristal.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.kristal.demo.Vo.ChangePasswordVo;
import com.kristal.demo.Vo.LoginVo;
import com.kristal.demo.model.Users;
import com.kristal.demo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public boolean login(@RequestBody LoginVo loginVo)
    {
        return userService.loginService(loginVo.getUserName(),loginVo.getPassword());
    }

    @PostMapping("/changePassword")
    public boolean changePassword(@RequestBody ChangePasswordVo changePasswordVo)
    {
        return userService.changePassword(changePasswordVo);

    }

    @PostMapping("/edit")
    public Users edit(@RequestBody LoginVo loginVo)
    {
        return userService.editUser(loginVo);
    }
}
