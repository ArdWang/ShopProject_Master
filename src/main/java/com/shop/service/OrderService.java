package com.shop.service;

import com.shop.model.order.OrderInfo;
import com.shop.model.order.OrderGoods;
import com.shop.model.order.Orders;
import java.util.List;
import java.util.Map;

public interface OrderService {

    int insetSubmitCart(OrderInfo orderBean);

    int insetOrderGoods(OrderGoods orderGoods);

    Orders getOrder(Map<Object,Object> params);

    int updateOrderInfo(OrderInfo orderInfo);

    List<Orders> getOrderList(Integer userId,Integer orderStatus);

    List<Orders> getOrderListAll(Integer userId,Integer orderStatus);

    int updateOrderStatus(Map<Object,Object> params);
}
