package org.backstage.bvw.service;

import org.backstage.bvw.domain.User;
import org.backstage.bvw.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public List<User> userList(){
        return userMapper.userList();
    }

    public User getuser(String name){
        return userMapper.getUserByName(name);
    }

    public void adduser(User user){
        userMapper.insertUser(user);
    }

    public List<String> userNameList(){
        return userMapper.getUserName();
    }
}
