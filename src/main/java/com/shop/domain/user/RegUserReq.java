package com.shop.domain.user;

import com.shop.domain.BaseReq;

public class RegUserReq extends BaseReq {
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //String mobile, String verifyCode, String password
    private String mobile;
    private String verifyCode;
    private String password;
}
