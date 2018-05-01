package com.shop.mapper;

import com.shop.model.category.CateGoryp;
import com.shop.model.category.CateGorys;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CateGoryMapper {

    /**
     * 获取对应父类分类
     * @return
     */
    @Select("select * from categoryp_tb")
    List<CateGoryp> getGatepGory();

    /**
     * 获取对应的子类id 通过父类id来查询
     * @param categorypid
     * @return
     */
    @Select("select * from categorys_tb where categorypid=#{categorypid}")
    List<CateGorys> getGatesGory(@Param("categorypid") Integer categorypid);


}
