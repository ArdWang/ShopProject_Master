package com.shop.controller;


import com.shop.domain.BaseResp;
import com.shop.domain.category.GateGorysResp;
import com.shop.domain.category.GetCateCoryReq;
import com.shop.model.category.CateGoryp;
import com.shop.model.category.CateGorys;
import com.shop.service.CateGoryService;
import com.shop.utils.util.StatusCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
@RequestMapping(produces = {"application/json;charset=UTF-8"}, value = {"/cate"})
public class CateGoryController extends BaseController{

    @Autowired
    private CateGoryService cateGoryService;

    private static final Logger logger = LoggerFactory.getLogger(CateGoryController.class);

    @RequestMapping(value = {"/getCateGoryp"}, method = {RequestMethod.POST})
    @ResponseBody
    public BaseResp<List<CateGoryp>> getCatepGory(){
        BaseResp resp = new BaseResp();
        try{
            List<CateGoryp> cateGorypList = cateGoryService.getGatepGory();
            if((cateGorypList==null)||cateGorypList.size()==0){
                resp.setCode(StatusCode.CODE_ERROR);
                resp.setMessage("获取列表失败");
                return resp;
            }

            resp.setCode(StatusCode.CODE_SUCCESS);
            resp.setMessage("获取列表成功");
            resp.setData(cateGorypList);
            return resp;

        }catch (Exception e){
            logger.error("Error",e);
            e.printStackTrace();
            resp.setCode(StatusCode.CODE_SERVER_ERROR);
            resp.setMessage("服务器错误");
            return resp;
        }
    }

    @RequestMapping(value = {"/getCateGorys"}, method = {RequestMethod.POST})
    @ResponseBody
    public GateGorysResp getCatesGory(@RequestBody GetCateCoryReq req){
        GateGorysResp resp = new GateGorysResp();
        try{
            int catecoryId = req.getCategoryId();
            List<CateGorys> cateGorysList = cateGoryService.getCatesGory(catecoryId);

            if((cateGorysList==null)||cateGorysList.size()==0){
                resp.setCode(StatusCode.CODE_ERROR);
                resp.setMessage("获取列表失败");
                resp.setCateGorys(null);
                return resp;
            }

            resp.setCode(StatusCode.CODE_SUCCESS);
            resp.setMessage("获取列表成功");
            resp.setCateGorys(cateGorysList);
            return resp;

        }catch (Exception e){
            logger.error("Error",e);
            e.printStackTrace();
            resp.setCode(StatusCode.CODE_SERVER_ERROR);
            resp.setMessage("服务器错误");
            resp.setCateGorys(null);
            return resp;
        }
    }


}
