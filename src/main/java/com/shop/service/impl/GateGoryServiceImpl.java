package com.shop.service.impl;

import com.shop.mapper.CateGoryMapper;
import com.shop.model.category.CateGoryp;
import com.shop.model.category.CateGorys;
import com.shop.service.CateGoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GateGoryServiceImpl implements CateGoryService{

    @Autowired
    private CateGoryMapper cateGoryMapper;

    @Override
    public List<CateGoryp> getGatepGory() {
        return cateGoryMapper.getGatepGory();
    }

    @Override
    public List<CateGorys> getCatesGory(Integer categoryId) {
        return cateGoryMapper.getGatesGory(categoryId);
    }

}
