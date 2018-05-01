package com.shop.model.goods;

import java.util.List;

public class GoodsSkuCon {
    private Integer goodsskuid;

    public Integer getGoodsskuid() {
        return goodsskuid;
    }

    public void setGoodsskuid(Integer goodsskuid) {
        this.goodsskuid = goodsskuid;
    }

    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }

    public String getGoodsskutitle() {
        return goodsskutitle;
    }

    public void setGoodsskutitle(String goodsskutitle) {
        this.goodsskutitle = goodsskutitle;
    }

    private Integer goodsid;
    private String goodsskutitle;

    public String getGoodsskucontent() {
        return goodsskucontent;
    }

    public void setGoodsskucontent(String goodsskucontent) {
        this.goodsskucontent = goodsskucontent;
    }

    private String goodsskucontent;
}
