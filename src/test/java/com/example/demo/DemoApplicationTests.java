package com.example.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class DemoApplicationTests {

    User user;
    @Resource
    UserMapper userMapper;
    @Test
    void contextLoads() {
    }
    @Test
    public void testDelete() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .ge("user_id", 3);
        User user = userMapper.selectOne(queryWrapper);
        System.out.println(user);
    }


}
