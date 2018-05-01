package com.shop.service.impl;

import com.shop.mapper.CartMapper;
import com.shop.model.cart.CartGoods;
import com.shop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CartServiceImpl implements CartService{
    @Autowired
    private CartMapper cartMapper;
    @Override
    public List<CartGoods> getCartList(Integer userid) {
        return cartMapper.getCartList(userid);
    }

    @Override
    public int insertCart(CartGoods cartGoodsBean) {
        int updatedata = cartMapper.insertCart(cartGoodsBean);
        if(updatedata>0){
            int userid = cartGoodsBean.getUserid();
            int count = cartMapper.getCartList(userid).size();
            if(count>0){
                return count;
            }
        }
        return 0;
    }

    /**
     * 删除数据操作
     * @return
     */
    @Override
    public Boolean deleteCart(List<Integer> goodsCartIds,int userId) {
        boolean a = false;
        for(Integer cartid:goodsCartIds) {
            Map<Object, Object> params = new HashMap<>();
            params.put("userid", userId);
            params.put("cartid", cartid);
            int deleteCart = cartMapper.deleteCart(params);
            if(deleteCart>0){
                a=true;
            }
        }
        if(a){
            return true;
        }
        return false;
    }
}
