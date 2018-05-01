package com.shop.domain.cart;

public class AddCartReq {

    /**
     * goodscount : 1
     * goodsdesc : Apple 苹果 MacBook Pro 笔记本电脑 16年新款 15英寸 Multi-Touch Bar 256G 深空灰色
     * goodsicon : https://img14.360buyimg.com/n5/s450x450_jfs/t3397/55/762020838/184157/7e507d32/58131c17Nb108ca54.jpg
     * goodsid : 5
     * goodsprice : 8.00
     * goodssku : 13英寸 Core i5 8G内存 256G闪存,银色
     */

    private int goodscount;
    private String goodsdesc;
    private String goodsicon;
    private int goodsid;

    public Float getGoodsprice() {
        return goodsprice;
    }

    public void setGoodsprice(Float goodsprice) {
        this.goodsprice = goodsprice;
    }

    private Float goodsprice;
    private String goodssku;

    public int getGoodscount() {
        return goodscount;
    }

    public void setGoodscount(int goodscount) {
        this.goodscount = goodscount;
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

    public int getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(int goodsid) {
        this.goodsid = goodsid;
    }

    public String getGoodssku() {
        return goodssku;
    }

    public void setGoodssku(String goodssku) {
        this.goodssku = goodssku;
    }
}
