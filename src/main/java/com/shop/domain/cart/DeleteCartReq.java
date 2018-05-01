package com.shop.domain.cart;



import java.util.List;

/**
 * 删除购物车的Req
 */
public class DeleteCartReq {
    private List<Integer> cartIdList;
    public List<Integer> getCartIdList() {
        return cartIdList;
    }
    public void setCartIdList(List<Integer> cartIdList) {
        this.cartIdList = cartIdList;
    }
}
