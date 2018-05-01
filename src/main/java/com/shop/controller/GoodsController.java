package com.shop.controller;

import com.github.pagehelper.PageHelper;
import com.shop.domain.BaseResp;
import com.shop.domain.goods.GetGoodsDetailReq;
import com.shop.domain.goods.GetGoodsInfoReq;
import com.shop.domain.goods.GetGoodsKeyWordReq;
import com.shop.model.goods.GoodsInfo;
import com.shop.service.GoodsService;
import com.shop.utils.util.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(produces = {"application/json;charset=UTF-8"}, value = {"/goods"})
public class GoodsController extends BaseController{

    @Autowired
    private GoodsService goodsService;

    @RequestMapping(value = {"/getGoodsInfo"}, method = {RequestMethod.POST})
    @ResponseBody
    public BaseResp<List<GoodsInfo>> getGoodsInfo(@RequestBody GetGoodsInfoReq req){
        BaseResp resp = new BaseResp();
        try{
            int categorypId = req.getCategorypid();
            int categorysId = req.getCategorysid();
            int pageIndex = req.getPageIndex();
            int pageSize = req.getPageSize();

            PageHelper.startPage(pageIndex,pageSize);

            Map<Object,Object> params = new HashMap<>();
            params.put("categorypid",categorypId);
            params.put("categorysid",categorysId);

            List<GoodsInfo> goodsInfoList = goodsService.getGoodsInfo(params);

            if(goodsInfoList==null){
                resp.setCode(StatusCode.CODE_ERROR);
                resp.setMessage("获取商品列表失败");
                return resp;
            }

            resp.setCode(StatusCode.CODE_SUCCESS);
            resp.setMessage("获取成功");
            resp.setData(goodsInfoList);
            return resp;

        }catch (Exception e){
            e.printStackTrace();
            resp.setCode(StatusCode.CODE_SERVER_ERROR);
            resp.setMessage("服务器错误");
            return resp;
        }
    }

    @RequestMapping(value = {"/getGoodsKeyWord"}, method = {RequestMethod.POST})
    @ResponseBody
    public BaseResp<List<GoodsInfo>> getGoodsKeyWord(@RequestBody GetGoodsKeyWordReq req){
        BaseResp resp = new BaseResp();
        try{
            int pageIndex = req.getPageIndex();
            int pageSize = req.getPageSize();
            String keyWord = req.getKeyWord();

            if(keyWord==null||keyWord.isEmpty()){
                resp.setCode(StatusCode.CODE_ERROR);
                resp.setMessage("输入查询的不应为空");
                return resp;
            }

            PageHelper.startPage(pageIndex,pageSize);

            List<GoodsInfo> goodsInfoList = goodsService.getGoodsByKeyWord(keyWord);

            if(goodsInfoList==null){
                resp.setCode(StatusCode.CODE_ERROR);
                resp.setMessage("没有该商品");
                return resp;
            }

            resp.setCode(StatusCode.CODE_SUCCESS);
            resp.setMessage("查询成功");
            resp.setData(goodsInfoList);
            return resp;

        }catch (Exception e){
            e.printStackTrace();
            resp.setCode(StatusCode.CODE_SERVER_ERROR);
            resp.setMessage("服务器错误");
            return resp;
        }
    }


    @RequestMapping(value = {"/getGoodsDetail"}, method = {RequestMethod.POST})
    @ResponseBody
    public BaseResp<GoodsInfo> getGoodsDetail(@RequestBody GetGoodsDetailReq req){
        BaseResp resp = new BaseResp();
        try{
            Integer goodsId = req.getGoodsId();

            GoodsInfo goodsInfo= goodsService.getGoodsDetail(goodsId);

            if(goodsInfo==null){
                resp.setCode(StatusCode.CODE_ERROR);
                resp.setMessage("没有商品的详细数据");
                return resp;
            }

            resp.setCode(StatusCode.CODE_SUCCESS);
            resp.setMessage("获取商品数据成功");
            resp.setData(goodsInfo);
            return resp;

        }catch (Exception e){
            e.printStackTrace();
            resp.setCode(StatusCode.CODE_SERVER_ERROR);
            resp.setMessage("服务器错误");
            return resp;
        }
    }

}
