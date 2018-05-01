package com.shop.service;


import com.shop.model.goods.GoodsInfo;
import com.shop.model.goods.GoodsSku;
import java.util.List;
import java.util.Map;

public interface GoodsService {

    List<GoodsInfo> getGoodsInfo(Map<Object,Object> params);

    List<GoodsInfo> getGoodsByKeyWord(String keyword);

    GoodsInfo getGoodsDetail(Integer goodsid);
}
