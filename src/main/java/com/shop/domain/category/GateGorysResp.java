package com.shop.domain.category;

import com.shop.model.category.CateGorys;

import java.io.Serializable;
import java.util.List;

public class GateGorysResp implements Serializable {
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<CateGorys> getCateGorys() {
        return cateGorys;
    }

    public void setCateGorys(List<CateGorys> cateGorys) {
        this.cateGorys = cateGorys;
    }

    private String message;
    private List<CateGorys> cateGorys;
}
