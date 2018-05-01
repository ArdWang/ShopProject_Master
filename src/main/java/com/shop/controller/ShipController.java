package com.shop.controller;


import com.shop.domain.BaseResp;
import com.shop.domain.ship.AddShipAddreReq;
import com.shop.domain.ship.DeleteShipAddreReq;
import com.shop.domain.ship.EditShipAddreReq;
import com.shop.domain.ship.ShipAddreResp;
import com.shop.model.ship.ShipAddre;
import com.shop.service.ShipService;
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
@RequestMapping(produces = {"application/json;charset=UTF-8"}, value = {"/ship"})
public class ShipController extends BaseController{
    @Autowired
    private ShipService shipService;


    @RequestMapping(value = {"/getShipList"}, method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public ShipAddreResp getShipAddre(){
        ShipAddreResp resp = new ShipAddreResp();
        try{
            int userId = Integer.parseInt(request.getHeader("token"));
            List<ShipAddre> shipList = shipService.getAllShip(userId);

            if((shipList==null)||(shipList.size()==0)){
                resp.setCode(StatusCode.CODE_ERROR);
                resp.setMessage("获取地址失败");
                resp.setShipAddres(null);
                return resp;
            }

            resp.setCode(StatusCode.CODE_SUCCESS);
            resp.setMessage("获取地址成功");
            resp.setShipAddres(shipList);
            return resp;

        }catch (Exception e){
            e.printStackTrace();
            resp.setCode(StatusCode.CODE_SERVER_ERROR);
            resp.setMessage("服务器错误");
            resp.setShipAddres(null);
            return resp;
        }
    }


    /**
     * 添加的运送地址
     */
    @RequestMapping(value = {"/addShip"}, method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public BaseResp addShipAddre(@RequestBody AddShipAddreReq req){
        BaseResp resp = new BaseResp();
        try{
            //得到UserId
            int userId = Integer.parseInt(request.getHeader("token"));
            String shipName = req.getShipName();
            String shipPhone = req.getShipPhone();
            String shipAddre = req.getShipAddre();

            //为空错误提示
            if(shipName==null||shipPhone==null||shipAddre==null||userId==0){
                resp.setCode(StatusCode.CODE_ERROR);
                resp.setMessage("输入不能为空");
                return resp;
            }

            List<ShipAddre> shipList = shipService.getAllShip(userId);
            ShipAddre spAddre = new ShipAddre();
            spAddre.setUserid(userId);
            spAddre.setShipusername(shipName);
            spAddre.setShipusermobile(shipPhone);
            spAddre.setShipaddress(shipAddre);

            if(shipList==null||shipList.size()==0){
                spAddre.setShipisdefault(1);
            }else{
                spAddre.setShipisdefault(0);
            }

            int insertShipOk = shipService.addShip(spAddre);

            if(insertShipOk==0){
                resp.setCode(StatusCode.CODE_ERROR);
                resp.setMessage("添加地址失败");
                return resp;
            }

            resp.setCode(StatusCode.CODE_SUCCESS);
            resp.setMessage("添加地址成功");
            return resp;


        }catch (Exception e){
            e.printStackTrace();
            resp.setCode(StatusCode.CODE_SERVER_ERROR);
            resp.setMessage("服务器错误");
            return resp;
        }
    }

    /**
     * 更新Ship表
     */
    @RequestMapping(value = {"/editShip"}, method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public BaseResp updateShip(@RequestBody EditShipAddreReq req){
        BaseResp resp = new BaseResp();
        try {
            int userId = Integer.parseInt(request.getHeader("token"));
            String shipName = req.getShipAddre().getShipusername();
            String shipPhone = req.getShipAddre().getShipusermobile();
            String shipAddre = req.getShipAddre().getShipaddress();
            int shipId = req.getShipAddre().getShipid();
            int shipIsDefult = req.getShipAddre().getShipisdefault();

            ShipAddre ship = new ShipAddre();

            ship.setUserid(userId);
            ship.setShipid(shipId);
            ship.setShipusername(shipName);
            ship.setShipusermobile(shipPhone);
            ship.setShipaddress(shipAddre);
            ship.setShipisdefault(shipIsDefult);

            if (shipIsDefult == 1) {
                for (ShipAddre sp : shipService.getAllShip(userId)) {
                    sp.setShipisdefault(0);
                    int updateShipj = shipService.updateShip(sp);

                    if(updateShipj==0){
                        resp.setCode(StatusCode.CODE_ERROR);
                        resp.setMessage("更改默认选择失败");
                        return resp;
                    }
                }
            }

            int updateShip = shipService.updateShip(ship);

            if(updateShip==0){
                resp.setCode(StatusCode.CODE_ERROR);
                resp.setMessage("修改失败");
                return resp;
            }

            resp.setCode(StatusCode.CODE_SUCCESS);
            resp.setMessage("修改地址成功");
            return resp;

        }catch (Exception e){
            e.printStackTrace();
            resp.setCode(StatusCode.CODE_SERVER_ERROR);
            resp.setMessage("服务器错误");
            return resp;
        }
    }

    /**
     * 删除地址
     */
    @RequestMapping(value = {"/deleteShip"}, method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public BaseResp deleteShip(@RequestBody DeleteShipAddreReq req){
        BaseResp resp = new BaseResp();
        try {
            int userId = Integer.parseInt(request.getHeader("token"));
            int shipId = req.getShipId();

            Map<Object,Object> params = new HashMap<>();
            params.put("userid",userId);
            params.put("shipid",shipId);

            int deleteShip = shipService.deleteShip(params);

            List<ShipAddre> shipAddres = shipService.getAllShip(userId);


            if(deleteShip==0){
                resp.setCode(StatusCode.CODE_ERROR);
                resp.setMessage("删除地址失败");
                return resp;
            }

            ShipAddre shipAddre = shipAddres.get(0);
            shipAddre.setShipisdefault(1);
            int ok=shipService.updateShip(shipAddre);

            if(ok==0){
                resp.setCode(StatusCode.CODE_ERROR);
                resp.setMessage("设置默认地址失败");
                return resp;
            }

            resp.setCode(StatusCode.CODE_SUCCESS);
            resp.setMessage("删除地址成功");
            return resp;

        }catch (Exception e){
            e.printStackTrace();
            resp.setCode(StatusCode.CODE_SERVER_ERROR);
            resp.setMessage("服务器错误");
            return resp;
        }
    }
}
