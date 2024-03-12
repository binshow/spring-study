package com.binshow._104springbootswagger.controller;


import com.binshow._104springbootswagger.dao.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@ApiOperation("用户管理")
@RestController
@RequestMapping("/user")
public class UserController {



    @GetMapping("/{id}")
    @ApiOperation("根据id查询用户")
    public User GetUserById(@PathVariable(value = "id" , required = true) @ApiParam("用户id") int id){
        User user = new User();
        user.setId(id);
        user.setName("binshow");
        return user;
    }
}
