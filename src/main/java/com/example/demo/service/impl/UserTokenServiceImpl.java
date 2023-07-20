package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.User;
import com.example.demo.entity.UserToken;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserTokenService;
import com.example.demo.mapper.UserTokenMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
* @author gamefive
* @description 针对表【user_token】的数据库操作Service实现
* @createDate 2023-07-12 14:23:17
*/
@Service
public class UserTokenServiceImpl extends ServiceImpl<UserTokenMapper, UserToken>
    implements UserTokenService{
    @Resource
    private UserMapper userMapper;
    @Resource
    private UserTokenMapper userTokenMapper;
    public String login(String loginName, String password){
        User user = userMapper.selectByLoginNameAndPassword(loginName, password);
        if(user != null){
            if(user.getDeleteStatus() == '1') {
                //暂时返回固定值，目前缺少结果枚举类
                return "deleted";
            }
            //暂时用固定token
            String token = "123456";
            UserToken userToken = userTokenMapper.selectByUserId(user.getUserId());
            Date now = new Date();
            Date expiredTime = new Date(now.getTime() + 3*24*3600*1000);
            //新建token
            if(userToken == null){
                userToken = new UserToken();
                userToken.setUserId(user.getUserId());
                userToken.setToken(token);
                userToken.setExpiredTime(expiredTime);
                userToken.setUpdatedTime(now);
                if(userTokenMapper.insertSelective(userToken) > 0){
                    return token;
                }
            } else {
                userToken.setToken(token);
                userToken.setExpiredTime(expiredTime);
                userToken.setUpdatedTime(now);
                if(userTokenMapper.updateByUserId(user.getUserId()) > 0){
                    return token;
            }
        }
    }
        return "ababa";
}
}




