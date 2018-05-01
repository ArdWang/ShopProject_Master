package com.shop.domain.msg;

import com.shop.domain.BaseReq;

public class UpdateMsgReq extends BaseReq{
    private Integer msgId;

    public Integer getMsgId() {
        return msgId;
    }

    public void setMsgId(Integer msgId) {
        this.msgId = msgId;
    }

    public Integer getMsgRead() {
        return msgRead;
    }

    public void setMsgRead(Integer msgRead) {
        this.msgRead = msgRead;
    }

    private Integer msgRead;
}
