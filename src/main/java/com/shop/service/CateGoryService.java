package com.shop.service;





import com.shop.model.category.CateGoryp;
import com.shop.model.category.CateGorys;
import java.util.List;

public interface CateGoryService {

    List<CateGoryp> getGatepGory();

    List<CateGorys> getCatesGory(Integer categoryId);
}
