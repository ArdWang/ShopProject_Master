package com.shop.domain.user;

import com.shop.domain.BaseReq;

public class ResetPwdReq extends BaseReq {
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String mobile;
    private String password;
}
