package com.shop.service.impl;

import com.shop.mapper.UserMapper;
import com.shop.model.user.User;
import com.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;


    @Override
    public User getUser(Map<Object, Object> params) {
        return userMapper.getUser(params);
    }

    @Override
    public int addUser(Map<Object, Object> params) {
        return userMapper.addUser(params);
    }

    @Override
    public int queryUser(String phone) {
        User user = userMapper.queryUser(phone);
        if(user!=null){
            return 1;
        }
        return 0;
    }

    @Override
    public int resetPwd(Map<Object, Object> params) {
        return userMapper.resetPwd(params);
    }


    @Override
    public User editUser(Map<Object, Object> params) {
        int update = userMapper.editUser(params);
        if(update>0){
            return userMapper.selectUser(params.get("userid").toString());
        }
        return null;
    }

    @Override
    public User selectUser(String userid) {
        return userMapper.selectUser(userid);
    }

    @Override
    public int editPushid(Map<Object, Object> params) {
        return userMapper.editPushid(params);
    }

    @Override
    public User getUserData(Integer userid) {
        return userMapper.getUserData(userid);
    }
}
