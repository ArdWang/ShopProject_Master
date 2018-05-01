package com.shop.service;

import com.shop.model.cart.CartGoods;


import java.util.List;

public interface CartService {

    List<CartGoods> getCartList(Integer userid);

    int insertCart(CartGoods cartGoodsBean);

    Boolean deleteCart(List<Integer> goodsCartIds,int userid);


}
