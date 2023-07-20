package com.example.demo.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.example.demo.entity.UserToken;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author gamefive
* @description 针对表【user_token】的数据库操作Mapper
* @createDate 2023-07-12 14:23:17
* @Entity com.example.demo.entity.UserToken
*/
public interface UserTokenMapper extends BaseMapper<UserToken> {
    int insertSelective(UserToken userToken);

    UserToken selectByUserId(@Param("userId") Long userId);

    UserToken selectByToken(@Param("token") String token);

    int updateByUserId(@Param("userId") Long userId);
}




