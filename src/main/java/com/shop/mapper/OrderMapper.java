package com.shop.mapper;


import com.shop.model.order.OrderInfo;
import com.shop.model.order.OrderGoods;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface OrderMapper {

    /**
     * 插入到订单表 并返回ID的值
     * @param orderBean
     * @return
     */
    @Insert("insert into orderinfo_tb(userid,shipid,paytype,totalprice,orderstatus)values(#{orderinfo_tb.userid},#{orderinfo_tb.shipid},#{orderinfo_tb.paytype},#{orderinfo_tb.totalprice},#{orderinfo_tb.orderstatus})")
    @Options(useGeneratedKeys = true, keyProperty = "orderinfo_tb.orderinfoid")
    int insertOrder(@Param("orderinfo_tb") OrderInfo orderBean);


    /**
     * 插入订单到商品购物车
     * @param orderGoods
     * @return
     */
    @Insert("insert into ordergoods_tb(userid,goodsid,orderinfoid,goodsdesc,goodsicon,goodsprice,goodscount,goodssku)values(#{userid},#{goodsid},#{orderinfoid},#{goodsdesc},#{goodsicon},#{goodsprice},#{goodscount},#{goodssku})")
    int insetOrderGoods(OrderGoods orderGoods);


    /**
     * 查询订单 根据订单的 Id 来查询
     */
    @Select("select * from ordergoods_tb where orderinfoid=#{orderinfoid} and userid=#{userid}")
    List<OrderGoods> getOrderGoods(Map<Object,Object> params);


    /**
     * 根据orderinfoid订单来查询大的订单
     */
    @Select("select * from orderinfo_tb where orderinfoid=#{orderinfoid} and userid=#{userid}")
    OrderInfo getOrderInfo(Map<Object,Object> params);

    @Update("update orderinfo_tb set userid=#{userid},shipid=#{shipid},paytype=#{paytype},totalprice=#{totalprice},orderstatus=#{orderstatus} where orderinfoid=#{orderinfoid} and userid=#{userid}")
    int updateOrderInfo(OrderInfo orderInfo);

    /**
     * 查询所有的商品
     */
    @Select("select * from orderinfo_tb where orderstatus=#{orderstatus} and userid=#{userid} order by orderinfoid desc")
    List<OrderInfo> getOrderInfoList(Map<Object,Object> params);


    @Select("select * from orderinfo_tb where userid=#{userid} order by orderinfoid desc")
    List<OrderInfo> getOrderInfoListT(@Param("userid") Integer userid);


    /*
        根据订单状态查询改订单
     */
    @Update("update orderinfo_tb set orderstatus=#{orderstatus} where orderinfoid=#{orderinfoid} and userid=#{userid} order by orderinfoid desc")
    int updateOrderStatus(Map<Object,Object> params);


}
