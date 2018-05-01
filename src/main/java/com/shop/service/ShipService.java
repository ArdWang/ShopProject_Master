package com.shop.service;

import com.shop.model.ship.ShipAddre;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ShipService {

    int addShip(ShipAddre shipAddre);

    ShipAddre getShip(Integer userid);

    List<ShipAddre> getAllShip(Integer userid);

    int updateShip(ShipAddre shipAddre);

    int deleteShip(Map<Object,Object> params);
}
