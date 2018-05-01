package com.shop.model.order;

/**
 * OderGoods订单商品表
 */
public class OrderGoods {

    public Integer getOrdergoodsid() {
        return ordergoodsid;
    }

    public void setOrdergoodsid(Integer ordergoodsid) {
        this.ordergoodsid = ordergoodsid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }

    public Integer getOrderinfoid() {
        return orderinfoid;
    }

    public void setOrderinfoid(Integer orderinfoid) {
        this.orderinfoid = orderinfoid;
    }

    public String getGoodsdesc() {
        return goodsdesc;
    }

    public void setGoodsdesc(String goodsdesc) {
        this.goodsdesc = goodsdesc;
    }

    public String getGoodsicon() {
        return goodsicon;
    }

    public void setGoodsicon(String goodsicon) {
        this.goodsicon = goodsicon;
    }

    public Integer getGoodscount() {
        return goodscount;
    }

    public void setGoodscount(Integer goodscount) {
        this.goodscount = goodscount;
    }

    public String getGoodssku() {
        return goodssku;
    }

    public void setGoodssku(String goodssku) {
        this.goodssku = goodssku;
    }

    private Integer ordergoodsid;
    private Integer userid;
    private Integer goodsid;
    private Integer orderinfoid;
    private String goodsdesc;
    private String goodsicon;

    public Float getGoodsprice() {
        return goodsprice;
    }

    public void setGoodsprice(Float goodsprice) {
        this.goodsprice = goodsprice;
    }

    private Float goodsprice;
    private Integer goodscount;
    private String goodssku;



}
