package com.shop.model.cart;

/**
 * 购物车商品Bean
 */
public class CartGoods {

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

    public Integer getCartid() {
        return cartid;
    }

    public void setCartid(Integer cartid) {
        this.cartid = cartid;
    }

    public Float getGoodsprice() {
        return goodsprice;
    }

    public void setGoodsprice(Float goodsprice) {
        this.goodsprice = goodsprice;
    }

    private Integer cartid;
    private Integer userid;
    private Integer goodsid;
    private String goodsdesc;
    private String goodsicon;
    private Float goodsprice;
    private Integer goodscount;
    private String goodssku;
}
