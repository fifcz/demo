package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import com.example.demo.service.UserTokenService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.beans.Transient;
import java.util.List;

@RestController
@ResponseBody
@Api(description = "用户接口")
public class UserController {
    @Resource
    UserMapper userMapper;

    @Autowired
    UserService userService;

    @Autowired
    UserTokenService userTokenService;

    @ApiOperation(value = "查询所有用户")
    @GetMapping ("/user")
    public List<User> queryAll(){
        return userMapper.findAllUsers();
    }

    @GetMapping("/userid")
    public  User user(long userId){
        return userService.getUserById(userId);
    }

    @PostMapping("/user/add")
    public boolean insertUser(User user){
        return userService.insertUser(user);
    }

    @DeleteMapping("/user/delete")
    public boolean deleteUser(long userId){
        return userService.deleteUser(userId);
    }

    @PutMapping("/user/update")
    public boolean updateUser(User user){
        return userService.updateUser(user);
    }

    @PostMapping("/user/login")
    public String login(String loginName, String password){
        return userTokenService.login(loginName, password);
    }

    @GetMapping("/user/test")
    public List<User> testList(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.ge("delete_status",0);
        return userMapper.selectList(queryWrapper);
    }
}
