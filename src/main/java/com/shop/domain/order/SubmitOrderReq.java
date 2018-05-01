package com.shop.domain.order;

import com.shop.model.order.Orders;

import java.util.List;

public class SubmitOrderReq {
    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    private Orders orders;
}
