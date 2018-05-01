package com.shop.service.impl;

import com.shop.mapper.GoodsMapper;
import com.shop.model.goods.GoodsInfo;
import com.shop.model.goods.GoodsSku;
import com.shop.model.goods.GoodsSkuCon;
import com.shop.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<GoodsInfo> getGoodsInfo(Map<Object,Object> params) {
        List<GoodsInfo> goodsInfoList = new ArrayList<>();
        List<GoodsSku> skuList = new ArrayList<>();
        List<GoodsInfo> goodsInfos = goodsMapper.getGoodsInfo(params);
        for(GoodsInfo goodsInfo:goodsInfos){
            List<GoodsSkuCon> skuListc = goodsMapper.getGoodsSku(goodsInfo.getGoodsid());
            for(GoodsSkuCon gsk:skuListc){
                GoodsSku gsb = new GoodsSku();
                gsb.setGoodsid(gsk.getGoodsid());
                gsb.setGoodsskuid(gsk.getGoodsskuid());
                gsb.setGoodsskutitle(gsk.getGoodsskutitle());
                String []a = gsk.getGoodsskucontent().split(",");
                List<String> b = new ArrayList<>();
                for(String ai:a){
                    b.add(ai);
                }
                gsb.setGoodsskucon(b);
                skuList.add(gsb);
            }
            goodsInfo.setGoodsSkus(skuList);
            goodsInfoList.add(goodsInfo);
        }
        return goodsInfoList;
    }


    @Override
    public List<GoodsInfo> getGoodsByKeyWord(String keyword) {
        List<GoodsInfo> goodsInfoList = new ArrayList<>();
        List<GoodsSku> skuList = new ArrayList<>();
        List<GoodsInfo> goodsInfos = goodsMapper.getGoodsByKeyWord(keyword);
        for(GoodsInfo goodsInfo:goodsInfos){
            List<GoodsSkuCon> skuListc = goodsMapper.getGoodsSku(goodsInfo.getGoodsid());
            for(GoodsSkuCon gsk:skuListc){
                GoodsSku gsb = new GoodsSku();
                gsb.setGoodsid(gsk.getGoodsid());
                gsb.setGoodsskuid(gsk.getGoodsskuid());
                gsb.setGoodsskutitle(gsk.getGoodsskutitle());
                String []a = gsk.getGoodsskucontent().split(",");
                List<String> b = new ArrayList<>();
                for(String ai:a){
                    b.add(ai);
                }
                gsb.setGoodsskucon(b);
                skuList.add(gsb);
            }
            goodsInfo.setGoodsSkus(skuList);
            goodsInfoList.add(goodsInfo);
        }
        return goodsInfoList;
    }


    @Override
    public GoodsInfo getGoodsDetail(Integer goodsid) {
        GoodsInfo goodsInfo = goodsMapper.getGoodsDetail(goodsid);
        List<GoodsSku> skuList = new ArrayList<>();
        List<GoodsSkuCon> skuListc = goodsMapper.getGoodsSku(goodsInfo.getGoodsid());
        for(GoodsSkuCon gsk:skuListc){
            GoodsSku gsb = new GoodsSku();
            gsb.setGoodsid(gsk.getGoodsid());
            gsb.setGoodsskuid(gsk.getGoodsskuid());
            gsb.setGoodsskutitle(gsk.getGoodsskutitle());
            String []a = gsk.getGoodsskucontent().split(",");
            List<String> b = new ArrayList<>();
            for(String ai:a){
                b.add(ai);
            }
            gsb.setGoodsskucon(b);
            skuList.add(gsb);
        }
        goodsInfo.setGoodsSkus(skuList);
        return goodsInfo;
    }

}
