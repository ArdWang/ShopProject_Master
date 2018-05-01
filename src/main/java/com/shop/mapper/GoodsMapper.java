package com.shop.mapper;

import com.shop.model.goods.GoodsInfo;
import com.shop.model.goods.GoodsSku;
import com.shop.model.goods.GoodsSkuCon;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;
import java.util.Map;

public interface GoodsMapper {

    /**
     * 查询所有的商品详细
     * @param params
     * @return
     */
    @Select("select * from goodsinfo_tb where categorypid = #{categorypid} and categorysid=#{categorysid}")
    List<GoodsInfo> getGoodsInfo(Map<Object,Object> params);

    /**
     * 获取商品Sku
     * @param goodsid
     * @return
     */
    @Select("select * from goodssku_tb where goodsid=#{goodsid}")
    List<GoodsSkuCon> getGoodsSku(@Param("goodsid") Integer goodsid);

    /**
     * 参数形式 商品描述来搜索
     * @param keyword
     * @return
     */
    @Select("select * from goodsinfo_tb where goodsdesc LIKE CONCAT('%', #{keyword}, '%')")
    List<GoodsInfo> getGoodsByKeyWord(@Param("keyword") String keyword);

    /**
     * 查询商品详细
     * @param goodsid
     * @return
     */
    @Select("select * from goodsinfo_tb where goodsid=#{goodsid}")
    GoodsInfo getGoodsDetail(@Param("goodsid") Integer goodsid);

}
