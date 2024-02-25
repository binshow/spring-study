package com.binshow._102springbootjdbc.controller;


import com.binshow._102springbootjdbc.bean.User;
import com.binshow._102springbootjdbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping("query")
    public User queryUserInfo(@RequestParam(value = "id",required = true) int id){
        return userService.queryById(id);
    }

}
