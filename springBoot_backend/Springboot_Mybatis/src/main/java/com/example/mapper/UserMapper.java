package com.example.mapper;

import com.example.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:wang tang
 */
@Repository
public interface UserMapper {

    User Sel(int id);

    List<User> selectUserList();

    void insertUser(User  user);

    int selectMaxNumber();
}
