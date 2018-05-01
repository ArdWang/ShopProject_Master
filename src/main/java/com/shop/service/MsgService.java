package com.shop.service;

import com.shop.model.msg.MsgInfo;
import java.util.List;
import java.util.Map;

public interface MsgService {

    List<MsgInfo> getMessage(Integer userid);

    int insertMessage(MsgInfo msgInfo);

    int updateMessage(Map<Object, Object> params);

    int deleteMessage(Map<Object, Object> params);
}
