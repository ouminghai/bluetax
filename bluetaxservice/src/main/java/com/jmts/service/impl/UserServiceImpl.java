package com.jmts.service.impl;

import com.jmts.dao.UserMapper;
import com.jmts.pojo.User;
import com.jmts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    public UserMapper userMapper;


    @Override
    public User getUserById(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }
}
