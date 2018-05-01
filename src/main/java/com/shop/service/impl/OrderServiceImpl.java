package com.shop.service.impl;

import com.shop.mapper.OrderMapper;
import com.shop.mapper.ShipMapper;
import com.shop.model.order.OrderInfo;
import com.shop.model.order.OrderGoods;
import com.shop.model.order.Orders;
import com.shop.model.ship.ShipAddre;
import com.shop.service.OrderService;
import com.shop.utils.util.YuanFenConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private ShipMapper shipMapper;

    @Override
    public int insetSubmitCart(OrderInfo orderBean) {
        int insertOk = orderMapper.insertOrder(orderBean);
        if(insertOk>0){
            int orderId = orderBean.getOrderinfoid();
            return orderId;
        }
        return 0;
    }


    @Override
    public int insetOrderGoods(OrderGoods orderGoods) {
        int insertok = orderMapper.insetOrderGoods(orderGoods);
        if(insertok>0){
            return insertok;
        }
        return 0;
    }

    /**
     * 返回所有的订单 通过用户id和订单的信息id
     * 所有订单的信息返回
     * @param params
     * @return
     */
    @Override
    public Orders getOrder(Map<Object, Object> params) {
        List<OrderGoods> orderGoods = orderMapper.getOrderGoods(params);
        OrderInfo orderInfo = orderMapper.getOrderInfo(params);
        int userid = Integer.parseInt(params.get("userid").toString());
        ShipAddre shipAddre = shipMapper.getShip(userid);
        Orders orders = new Orders();

        if(orderInfo!=null){
            orders.setOrderId(orderInfo.getOrderinfoid());
            orders.setPayType(orderInfo.getPaytype());
            orders.setTotalPrice(YuanFenConverter.changeY2FWJ(orderInfo.getTotalprice()));
            orders.setOrderStatus(orderInfo.getOrderstatus());
            orders.setShipid(orderInfo.getShipid());
            orders.setShipAddre(shipAddre);

            if(orderGoods.size()>0){
                orders.setOrderGoods(orderGoods);
            }
            return orders;
        }
        return null;
    }

    @Override
    public int updateOrderInfo(OrderInfo orderInfo) {
        int updateOk = orderMapper.updateOrderInfo(orderInfo);
        if(updateOk>0){
            return updateOk;
        }
        return 0;
    }


    @Override
    public List<Orders> getOrderList(Integer userId, Integer orderStatus) {
        List<Orders> ordersList = new ArrayList<>();
        Map<Object, Object> params = new HashMap<>();

        params.put("userid", userId);
        params.put("orderstatus", orderStatus);

        List<OrderInfo> orderInfos = orderMapper.getOrderInfoList(params);

        if (orderInfos != null && orderInfos.size() > 0) {
            for (OrderInfo info : orderInfos) {

                Orders orders = new Orders();

                orders.setOrderId(info.getOrderinfoid());
                orders.setOrderStatus(info.getOrderstatus());
                orders.setPayType(info.getPaytype());
                orders.setTotalPrice(YuanFenConverter.changeY2FWJ(info.getTotalprice()));
                orders.setShipid(info.getShipid());

                Map<Object, Object> p1 = new HashMap<>();
                p1.put("userid", userId);
                p1.put("shipid", info.getShipid());

                ShipAddre shipAddre = shipMapper.getOrderShip(p1);

                orders.setShipAddre(shipAddre);

                Map<Object, Object> params1 = new HashMap<>();

                params1.put("userid", userId);
                params1.put("orderinfoid", info.getOrderinfoid());

                List<OrderGoods> orderGoods = orderMapper.getOrderGoods(params1);

                orders.setOrderGoods(orderGoods);

                ordersList.add(orders);
            }

            return ordersList;
        }

        return null;
    }

    /**
        得到全部的设备
     */
    @Override
    public List<Orders> getOrderListAll(Integer userId, Integer orderStatus) {

        List<Orders> ordersList = new ArrayList<>();

        List<OrderInfo> orderInfos = orderMapper.getOrderInfoListT(userId);
        if (orderInfos != null && orderInfos.size() > 0) {
            for (OrderInfo info : orderInfos) {
                Orders orders = new Orders();
                orders.setOrderId(info.getOrderinfoid());
                orders.setOrderStatus(info.getOrderstatus());
                orders.setPayType(info.getPaytype());
                orders.setTotalPrice(YuanFenConverter.changeY2FWJ(info.getTotalprice()));
                orders.setShipid(info.getShipid());

                Map<Object, Object> p1 = new HashMap<>();

                p1.put("userid", userId);
                p1.put("shipid", info.getShipid());

                ShipAddre shipAddre = shipMapper.getOrderShip(p1);
                orders.setShipAddre(shipAddre);

                Map<Object, Object> params1 = new HashMap<>();
                params1.put("userid", userId);
                params1.put("orderinfoid", info.getOrderinfoid());

                List<OrderGoods> orderGoods = orderMapper.getOrderGoods(params1);

                orders.setOrderGoods(orderGoods);
                ordersList.add(orders);
            }
            return ordersList;
        }

        return null;
    }

    @Override
    public int updateOrderStatus(Map<Object, Object> params) {
        int updateStatus = orderMapper.updateOrderStatus(params);
        if(updateStatus>0){
            return updateStatus;
        }
        return 0;
    }
}
