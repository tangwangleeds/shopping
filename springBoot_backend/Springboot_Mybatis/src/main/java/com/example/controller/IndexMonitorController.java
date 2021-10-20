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
/**
 *
 * @author wangtang
 */
@Slf4j
@RestController
@RequestMapping("/indexMonitor")
public class IndexMonitorController {


    @Autowired
    private MonitorService monitorService;

    @RequestMapping("getMonitorIndex/{id}")
    public String GetMonitorIndex(@PathVariable int id){
        return monitorService.Sel(id).toString();
    }

    @RequestMapping("insertMonitor/{count}")
    public String insertMonitor(@PathVariable int count){
        monitorService.insertUser(count);
        return "ok";
    }

    @RequestMapping("selectMonitorList")
    public String selectMonitorList(){
        Gson gson =new Gson();
        List<User> list= monitorService.selectUserList();
        return gson.toJson(list).toString();
    }






}
