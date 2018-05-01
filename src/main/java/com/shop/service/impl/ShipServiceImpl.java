package com.shop.service.impl;

import com.shop.mapper.ShipMapper;
import com.shop.model.ship.ShipAddre;
import com.shop.service.ShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ShipServiceImpl implements ShipService{

    @Autowired
    private ShipMapper shipMapper;

    @Override
    public int addShip(ShipAddre shipAddre) {
        int insertOk = shipMapper.addShip(shipAddre);
        if(insertOk>0){
            return insertOk;
        }
        return 0;
    }

    @Override
    public ShipAddre getShip(Integer userid) {
        return shipMapper.getShip(userid);
    }

    @Override
    public List<ShipAddre> getAllShip(Integer userid) {
        return shipMapper.getAllShip(userid);
    }

    @Override
    public int updateShip(ShipAddre shipAddre) {
        int update = shipMapper.updateShip(shipAddre);
        if(update>0){
            return 1;
        }
        return 0;
    }

    @Override
    public int deleteShip(Map<Object, Object> params) {
        int delete = shipMapper.deleteShip(params);
        if(delete>0){
            return 1;
        }
        return 0;
    }
}
