package com.shop.mapper;

import com.shop.model.user.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.Map;

public interface UserMapper {

    /**
     * 获取账号和密码 返回userBean
     * @param params
     * @return user
     */
    @Select("select * from user_tb where phone=#{phone} and password=#{password}")
    User getUser(Map<Object,Object> params);

    @Select("select * from user_tb where userid=#{userid}")
    User getUserData(@Param("userid") Integer userid);

    /**
     * 添加用户的接口
     * @param params
     * @return null
     */
    @Insert("insert into user_tb(phone,username,password) values(#{phone},#{username},#{password})")
    int addUser(Map<Object,Object> params);


    /**
     * 查询用户是否存在相同的用户名
     * @param phone
     * @return null
     */
    @Select("select * from user_tb where phone=#{phone}")
    User queryUser(@Param("phone") String phone);


    /**
     * 更新账号密码
     * @param params
     * @return
     */
    @Update("update user_tb set password=#{password} where phone=#{phone}")
    int resetPwd(Map<Object,Object> params);


    /**
     * 更新用户信息
     * @return
     */
    @Update("update user_tb set username=#{username},userimg=#{userimg},sex=#{sex},sign=#{sign} where userid=#{userid}")
    int editUser(Map<Object,Object> params);

    @Update("update user_tb set pushid=#{pushid} where userid=#{userid}")
    int editPushid(Map<Object,Object> params);

    /**
     * 查询用户
     * @param userid
     * @return
     */
    @Select("select * from user_tb where userid=#{userid}")
    User selectUser(@Param("userid") String userid);

}
