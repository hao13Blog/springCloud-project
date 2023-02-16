package com.lh.userservice.services.impl;

import com.lh.userservice.clients.UserClient;
import com.lh.userservice.mapper.UserMapper;
import com.lh.userservice.model.User;
import com.lh.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    UserClient userClient;

    @Override
    public User getUserInfo(Integer id) {
        return userMapper.getUserInfoById(id);
    }
}
