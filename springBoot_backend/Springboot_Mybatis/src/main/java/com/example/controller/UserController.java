package com.example.controller;

import com.example.entity.User;
import com.example.service.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 @author wangtang
 */

@RestController
@RequestMapping("/testBoot")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("getUser/{id}")
    public String GetUser(@PathVariable int id){
        return userService.Sel(id).toString();
    }

    @RequestMapping("insertUser/{count}")
    public String insertUser(@PathVariable int count){
        userService.insertUser(count);
        return "ok";
    }

    @RequestMapping("selectUserList")
    public String selectUserList(){
        Gson  gson =new Gson();
        List<User>  list= userService.selectUserList();
        return gson.toJson(list).toString();
    }

}
