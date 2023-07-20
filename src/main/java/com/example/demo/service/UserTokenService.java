package com.example.demo.service;

import com.example.demo.entity.UserToken;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author gamefive
* @description 针对表【user_token】的数据库操作Service
* @createDate 2023-07-12 14:23:17
*/
public interface UserTokenService extends IService<UserToken> {
    String login(String loginName, String password);

}
