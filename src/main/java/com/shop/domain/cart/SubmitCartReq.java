package com.shop.domain.cart;

import java.util.List;

public class SubmitCartReq {


    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    private Float totalPrice;
    private List<CartGoodsBean> cartGoods;

    public List<CartGoodsBean> getCartGoods() {
        return cartGoods;
    }

    public void setCartGoods(List<CartGoodsBean> cartGoods) {
        this.cartGoods = cartGoods;
    }

    public static class CartGoodsBean {
        /**
         * goodscount : 1
         * goodsdesc : Apple MacBook Air 13.3英寸笔记本电脑 银色(Core i5 处理器/8GB内存/128GB SSD闪存 MMGF2CH/A)
         * goodsicon : https://img11.360buyimg.com/n7/jfs/t2968/143/2485546147/238650/70df281e/57b12a31N8f4f75a3.jpg
         * goodsid : 1
         * goodsprice : 10
         * goodssku : 1.6GHz i5处理器,8GB内存/128GB SSD
         * isSelected : true
         * ordergoodsid : 12
         * userid : 1
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
        private boolean isSelected;

        public int getCartid() {
            return cartid;
        }

        public void setCartid(int cartid) {
            this.cartid = cartid;
        }

        private int cartid;
        private int userid;

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

        public boolean isIsSelected() {
            return isSelected;
        }

        public void setIsSelected(boolean isSelected) {
            this.isSelected = isSelected;
        }


        public int getUserid() {
            return userid;
        }

        public void setUserid(int userid) {
            this.userid = userid;
        }
    }
}
