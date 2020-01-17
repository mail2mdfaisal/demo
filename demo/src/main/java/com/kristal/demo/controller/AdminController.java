package com.kristal.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.kristal.demo.Vo.LoginVo;
import com.kristal.demo.model.Users;
import com.kristal.demo.service.AdminService;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/createUser")
    public ResponseEntity<Users> createUser(@RequestBody LoginVo loginVo) {
    	
    	Users user = adminService.createUser(loginVo);
    	if(user != null)
    		return new ResponseEntity<Users>(user, HttpStatus.OK);
    	
    	return new ResponseEntity<Users>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("getAllUsers")
    public List<Users> getAllUsers() {
        return adminService.getUsers();
    }

    @GetMapping("/getDetails/{userid}")
    public Users getUserDetails(@PathVariable("userid") Long userId)
    {
        return adminService.getUserDetail(userId);
    }
}
