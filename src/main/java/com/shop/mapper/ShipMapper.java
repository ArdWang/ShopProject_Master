package com.shop.mapper;

import com.shop.model.ship.ShipAddre;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;


public interface ShipMapper {
    /**
     * 插入收获地址
     * @param shipAddre
     * @return
     */
    @Insert("insert into shipaddress_tb(userid,shipusername,shipusermobile,shipaddress,shipisdefault)values(#{userid},#{shipusername},#{shipusermobile},#{shipaddress},#{shipisdefault})")
    int addShip(ShipAddre shipAddre);


    /**
     * 获取购物车地址
     * @return
     */
    @Select("select * from shipaddress_tb where userid=#{userid} and shipisdefault=1")
    ShipAddre getShip(@Param("userid") Integer userid);


    @Select("select * from shipaddress_tb where userid=#{userid} and shipid=#{shipid}")
    ShipAddre getOrderShip(Map<Object,Object> params);


    /**
     * 获取所以的ship
     * @return
     */
    @Select("select * from shipaddress_tb where userid=#{userid}")
    List<ShipAddre> getAllShip(@Param("userid") Integer userid);


    /**
     * 更新Ship表
     * @param shipAddre
     * @return
     */
    @Update("update shipaddress_tb set shipusername=#{shipusername},shipusermobile=#{shipusermobile},shipaddress=#{shipaddress},shipisdefault=#{shipisdefault} where shipid=#{shipid} and userid=#{userid}")
    int updateShip(ShipAddre shipAddre);


    /**
     * 删除Ship表的数据
     * @param params
     * @return
     */
    @Delete("delete from shipaddress_tb where shipid=#{shipid} and userid=#{userid}")
    int deleteShip(Map<Object,Object> params);


}
