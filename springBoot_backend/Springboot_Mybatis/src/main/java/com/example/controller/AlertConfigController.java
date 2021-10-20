package com.example.controller;


import com.example.entity.User;
import com.example.service.MonitorService;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/alert")
public class AlertConfigController {


    @Autowired
    private MonitorService monitorService;

    @RequestMapping("getAlert/{id}")
    public String getAlert(@PathVariable int id){
        return monitorService.Sel(id).toString();
    }

    @RequestMapping("insertAlert/{count}")
    public String insertAlert(@PathVariable int count){
        monitorService.insertUser(count);
        return "ok";
    }

    @RequestMapping("selectAlertList")
    public String selectAlertList(){
        Gson gson =new Gson();
        List<User> list= monitorService.selectUserList();
        return gson.toJson(list).toString();
    }






}
