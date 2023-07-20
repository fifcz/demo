package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author gamefive
* @description 针对表【user】的数据库操作Service实现
* @createDate 2023-06-27 15:18:49
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Resource
    private UserMapper userMapper;
    @Override
    public User getUserById(long userId) {
        return userMapper.selectByUserId(userId);
    }

    public boolean insertUser(User user){
        if(userMapper.insertSelective(user)>0){
            return true;
        }
        else {
            return  false;
        }
    }

    public  boolean deleteUser(long userId){
        if(userMapper.deleteByUserId(userId) != 0){
            return true;
        }
        else return false;
    }

    public boolean updateUser(User user){
        if(userMapper.updateSelective(user)>0){
            return true;
        }
        else {
            return  false;
        }
    }

}




