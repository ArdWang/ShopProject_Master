package com.shop.domain.order;

public class GetAllOrderReq {
    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    //{"orderStatus":1}
    private Integer orderStatus;
}
