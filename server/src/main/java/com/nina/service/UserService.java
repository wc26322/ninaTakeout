package com.nina.service;

import com.nina.dto.UserLoginDTO;
import com.nina.entity.User;

public interface UserService {

    /**
     * C端用户登录
     * @param userLoginDTO
     * @return
     */
    User wxLogin(UserLoginDTO userLoginDTO);
}
