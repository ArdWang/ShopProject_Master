package com.shop.service.impl;

import com.shop.mapper.MsgMapper;
import com.shop.model.msg.MsgInfo;
import com.shop.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MsgServiceImpl implements MsgService{
    @Autowired
    private MsgMapper msgMapper;

    @Override
    public List<MsgInfo> getMessage(Integer userid) {
        return msgMapper.getMessage(userid);
    }

    @Override
    public int insertMessage(MsgInfo msgInfo) {
        return msgMapper.insertMessage(msgInfo);
    }

    @Override
    public int updateMessage(Map<Object, Object> params) {
        return msgMapper.updateMessage(params);
    }

    @Override
    public int deleteMessage(Map<Object, Object> params) {
        return msgMapper.deleteMessage(params);
    }
}
