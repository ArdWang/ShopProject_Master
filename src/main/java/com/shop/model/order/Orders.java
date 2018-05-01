package com.shop.model.order;

import com.shop.model.ship.ShipAddre;

import java.util.List;

public class Orders {

    public List<OrderGoods> getOrderGoods() {
        return orderGoods;
    }

    public void setOrderGoods(List<OrderGoods> orderGoods) {
        this.orderGoods = orderGoods;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public ShipAddre getShipAddre() {
        return shipAddre;
    }

    public void setShipAddre(ShipAddre shipAddre) {
        this.shipAddre = shipAddre;
    }

    public Integer getShipid() {
        return shipid;
    }

    public void setShipid(Integer shipid) {
        this.shipid = shipid;
    }

    private Integer shipid;
    private Integer orderId;
    private Integer payType;

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    private Float totalPrice;
    private Integer orderStatus;
    private ShipAddre shipAddre;
    private List<OrderGoods> orderGoods;

}
