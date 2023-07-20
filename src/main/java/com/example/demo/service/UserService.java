package com.example.demo.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.example.demo.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author gamefive
* @description 针对表【user】的数据库操作Service
* @createDate 2023-06-27 15:18:49
*/
public interface UserService extends IService<User> {
    User getUserById(long userId);
    boolean insertUser(User user);
    boolean deleteUser(long userId);

    boolean updateUser(User user);

}
