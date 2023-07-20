package com.example.demo.mapper;

import com.example.demo.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author gamefive
* @description 针对表【user】的数据库操作Mapper
* @createDate 2023-06-27 15:18:49
* @Entity com.example.demo.entity.User
*/
public interface UserMapper extends BaseMapper<User> {
    List<User> findAllUsers();

    User selectByUserId(long userId);

    int insertSelective(User user);

    int deleteByUserId(@Param("userId") Long userId);

    int updateSelective(User user);

    User selectByLoginNameAndPassword(@Param("loginName") String loginName, @Param("password") String password);
}




