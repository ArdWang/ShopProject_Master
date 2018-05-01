package com.shop.mapper;

import com.shop.model.msg.MsgInfo;
import org.apache.ibatis.annotations.*;
import java.util.List;
import java.util.Map;

public interface MsgMapper {
    /**
        得到当前的消息
     */
    @Select("select * from message_tb where userid=#{userid} ORDER BY msgid desc")
    List<MsgInfo> getMessage(@Param("userid") Integer userid);

    /**
     * 插入消息信息
     */
    @Insert("insert into message_tb(userid,msgtype,msgtitle,msgcon,msgimg,msgtime,msgread)values(#{userid},#{msgtype},#{msgtitle},#{msgcon},#{msgimg},#{msgtime},#{msgread})")
    int insertMessage(MsgInfo msgInfo);

    /**
     * 更新消息信息
     */
    @Update("update message_tb set msgread=#{msgread} where userid=#{userid} and msgid=#{msgid}")
    int updateMessage(Map<Object, Object> params);

    /**
     * 删除当前的消息
     */
    @Delete("delete from message_tb where msgid=#{msgid} and userid=#{userid}")
    int deleteMessage(Map<Object, Object> params);
}
