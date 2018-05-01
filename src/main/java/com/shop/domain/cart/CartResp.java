package com.shop.domain.cart;

import com.shop.model.cart.CartGoods;

import java.io.Serializable;
import java.util.List;

public class CartResp implements Serializable {
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

    public List<CartGoods> getCartGoods() {
        return cartGoods;
    }

    public void setCartGoods(List<CartGoods> cartGoods) {
        this.cartGoods = cartGoods;
    }

    private String message;
    private List<CartGoods> cartGoods;
}
