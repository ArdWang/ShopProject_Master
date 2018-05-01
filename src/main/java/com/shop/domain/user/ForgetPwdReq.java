package com.shop.domain.user;

import com.shop.domain.BaseReq;

public class ForgetPwdReq extends BaseReq {
    private String mobile;

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

    private String verifyCode;
}
