package com.shop.domain.user;

import com.shop.domain.BaseReq;

public class GetUserReq extends BaseReq {
    /**
     * password : 123
     * phone : 123456
     */
    private String password;
    private String phone;

    public String getPushid() {
        return pushid;
    }

    public void setPushid(String pushid) {
        this.pushid = pushid;
    }

    private String pushid;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
