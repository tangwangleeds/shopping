package com.example.service;

import com.example.entity.User;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:WANGTANG
 */
@Service
public class MonitorService {


    @Autowired
    UserMapper userMapper;



    public User Sel(int id){
        return userMapper.Sel(id);
    }


    public List<User> selectUserList(){

        return   userMapper.selectUserList();
    }

    public void insertUser(int count){
        int maxNumber=userMapper.selectMaxNumber();
        for (int i=1;i<=count ;i++){
            User user=new User();
            user.setPassWord("123456");
            maxNumber=maxNumber+1;
            user.setUserName("user_"+maxNumber);
            user.setUserNumber(maxNumber);
            userMapper.insertUser(user);
        }
    }


}
