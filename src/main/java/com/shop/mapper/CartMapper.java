package com.shop.mapper;

import com.shop.model.cart.CartGoods;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;
import java.util.Map;

public interface CartMapper {

    @Select("select * from cartgoods_tb where userid=#{userid}")
    List<CartGoods> getCartList(@Param("userid") Integer userid);


    @Insert("insert into cartgoods_tb(userid,goodsid,goodsdesc,goodsicon,goodsprice,goodscount,goodssku)values(#{userid},#{goodsid},#{goodsdesc},#{goodsicon},#{goodsprice},#{goodscount},#{goodssku})")
    int insertCart(CartGoods cartGoodsBean);

    /**
     * 删除的数据库数据操作
     * @param params
     * @return
     */
    @Delete("delete from cartgoods_tb where userid=#{userid} and cartid=#{cartid}")
    int deleteCart(Map<Object,Object> params);


}
