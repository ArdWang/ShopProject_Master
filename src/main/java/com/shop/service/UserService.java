package com.shop.service;


import com.shop.model.user.User;
import java.util.Map;

public interface UserService {

    /**
     * 获取登录用户
     * @param params
     * @return
     */
    User getUser(Map<Object,Object> params);

    /**
     * 添加用户信息
     * @param params
     * @return
     */
    int addUser(Map<Object,Object> params);

    /**
     * 查询是否有相同的用户 以及找回密码 需要此接口
     * @param phone
     * @return
     */
    int queryUser(String phone);

    /**
     * 更新用户信息
     * @param params
     * @return
     */
    int resetPwd(Map<Object,Object> params);


    /**
     * 编辑用户资料
     * @param params
     * @return
     */
    User editUser(Map<Object,Object> params);

    /**
     * 查询用户信息
     * @param userid
     * @return
     */
    User selectUser(String userid);

    int editPushid(Map<Object,Object> params);

    User getUserData(Integer userid);




}
