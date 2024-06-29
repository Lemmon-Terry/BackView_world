package org.backstage.bvw.controller;

import org.backstage.bvw.domain.User;
import org.backstage.bvw.service.UserService;
import org.backstage.bvw.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Headers")
@ResponseBody
public class LoginController {

    @Autowired
    private UserService userService;


    @PostMapping("/login")
    public Result login(@RequestBody User reqUser) {
        String username = reqUser.getUsername();
        String password = reqUser.getPassword();



        User user = userService.getuser(username);
        if (user != null && user.getPassword().equals(password)) {
            return new Result("200", "登陆成功");
        } else if (user != null && user.getPassword().equals(password) == false) {
            return new Result("500","用户名或者密码输入有误");
        } else {
            return new Result("500","该用户不存在，请前往注册");
        }
    }

    @PostMapping("/register")
    public Result register(@RequestBody User reqUser) {
        String username = reqUser.getUsername();
        String password = reqUser.getPassword();

        User user = userService.getuser(username);
        if (user != null){
            return new Result("500","该用户已经存在");
        }else {
            User userInfo = new User();
            userInfo.setUsername(username);
            userInfo.setPassword(password);
            userService.adduser(userInfo);

            User AddedUser = userService.getuser(username);
            String Information = "增加了一条记录"+AddedUser;
            System.out.println(Information);
            return new Result("200", "用户注册成功",username);
        }
    }
}