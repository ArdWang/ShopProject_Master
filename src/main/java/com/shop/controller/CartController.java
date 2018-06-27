package com.shop.controller;


import com.shop.common.InitAction;
import com.shop.domain.BaseResp;
import com.shop.domain.cart.AddCartReq;
import com.shop.domain.cart.CartResp;
import com.shop.domain.cart.DeleteCartReq;
import com.shop.domain.cart.SubmitCartReq;
import com.shop.model.cart.CartGoods;
import com.shop.model.order.OrderInfo;
import com.shop.model.order.OrderGoods;
import com.shop.model.ship.ShipAddre;
import com.shop.service.CartService;
import com.shop.service.OrderService;
import com.shop.service.ShipService;
import com.shop.utils.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.ArrayList;
import java.util.List;

/**
 * 新的购物车接口 采用RequestBody 传递和接受参数
 */
@Controller
@RequestMapping(produces = {"application/json;charset=UTF-8"}, value = {"/cart"})
public class CartController extends BaseController{

    @Autowired
    private CartService cartService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ShipService shipService;

    private static final Logger logger = LoggerFactory.getLogger(CartController.class);

    /**
     * 添加购物车的商品
     */
    @RequestMapping(value = {"/addCart"}, method = {RequestMethod.POST})
    @ResponseBody
    public BaseResp<Integer> addCartGoods(@RequestBody AddCartReq req){
        BaseResp resp = new BaseResp();
        try{
            //得到UserId
            String userData = request.getHeader("token");
            if(userData.isEmpty()){
                resp.setCode(StatusCode.CODE_ERROR);
                resp.setMessage("用户token不能为空");
                return resp;
            }
            int userId = Integer.parseInt(userData);

            int goodsId = req.getGoodsid();
            String goodsDesc = req.getGoodsdesc();
            String goodsIcon = req.getGoodsicon();
            Float goodsPrice = req.getGoodsprice();
            int goodsCount = req.getGoodscount();
            String goodsSku = req.getGoodssku();

            CartGoods cartGoodsBean = new CartGoods();
            cartGoodsBean.setUserid(userId);
            cartGoodsBean.setGoodsid(goodsId);
            cartGoodsBean.setGoodscount(goodsCount);
            cartGoodsBean.setGoodsdesc(goodsDesc);
            cartGoodsBean.setGoodsicon(goodsIcon);
            cartGoodsBean.setGoodsprice(YuanFenConverter.changeY2FWJ(goodsPrice));
            cartGoodsBean.setGoodssku(goodsSku);

            int updateCount = cartService.insertCart(cartGoodsBean);

            if(updateCount==0){
                resp.setCode(StatusCode.CODE_ERROR);
                resp.setMessage("添加失败");
                return resp;
            }

            resp.setCode(StatusCode.CODE_SUCCESS);
            resp.setMessage("获取成功");
            resp.setData(updateCount);
            return resp;

        }catch (Exception e){
            logger.error("Error",e);
            e.printStackTrace();
            resp.setCode(StatusCode.CODE_SERVER_ERROR);
            resp.setMessage("服务器错误");
            return resp;
        }
    }

    /**
     * 删除购物车
     * @param req
     */
    @RequestMapping(value = {"/deleteCart"}, method = {RequestMethod.POST})
    @ResponseBody
    public BaseResp deleteCartGoods(@RequestBody DeleteCartReq req){
        BaseResp resp = new BaseResp();
        try {
            //得到UserId
            String userData = request.getHeader("token");
            if(userData.isEmpty()){
                resp.setCode(StatusCode.CODE_ERROR);
                resp.setMessage("用户token不能为空");
                return resp;
            }
            int userId = Integer.parseInt(userData);
            //得到传过来的购物车商品要删除的id
            List<Integer> goodsCartIds = req.getCartIdList();

            boolean a = cartService.deleteCart(goodsCartIds,userId);

            if(!a){
                resp.setCode(StatusCode.CODE_ERROR);
                resp.setMessage("删除失败");
                return resp;
            }

            resp.setCode(StatusCode.CODE_SUCCESS);
            resp.setMessage("删除成功");
            return resp;

        }catch (Exception e){
            logger.error("Error",e);
            e.printStackTrace();
            resp.setCode(StatusCode.CODE_SERVER_ERROR);
            resp.setMessage("服务器错误");
            return resp;
        }
    }

    /**
     * 获取购物车
     */
    @RequestMapping(value = {"/getCart"}, method = {RequestMethod.POST})
    @ResponseBody
    public CartResp getCartGoods(){
        CartResp resp = new CartResp();
        try {
            String userData = request.getHeader("token");
            if(userData.isEmpty()){
                resp.setCode(StatusCode.CODE_ERROR);
                resp.setMessage("用户token不能为空");
                return resp;
            }
            int userId = Integer.parseInt(userData);

            if(userId==0){
                resp.setCode(StatusCode.CODE_ERROR);
                resp.setMessage("你还没有登录");
                resp.setCartGoods(null);
                return resp;
            }

            List<CartGoods> cartGoods = cartService.getCartList(userId);
            if((cartGoods==null)||(cartGoods.size()==0)){
                resp.setCode(StatusCode.CODE_ERROR);
                resp.setMessage("获取列表数据失败");
                resp.setCartGoods(null);
                return resp;
            }

            resp.setCode(StatusCode.CODE_SUCCESS);
            resp.setMessage("获取成功");
            resp.setCartGoods(cartGoods);
            //System.out.println(resp.);
            return resp;

        }catch (Exception e){
            logger.error("Error",e);
            e.printStackTrace();
            resp.setCode(StatusCode.CODE_SERVER_ERROR);
            resp.setMessage("服务器错误");
            resp.setCartGoods(null);
            return resp;
        }
    }

    /**
     * 提交购物车的信息
     * @param req
     */
    @RequestMapping(value = {"/submitCart"}, method = {RequestMethod.POST})
    @ResponseBody
    public BaseResp<Integer> submitCart(@RequestBody SubmitCartReq req){
        BaseResp resp = new BaseResp();
        InitAction.init();
        try{
            List<Integer> cartIdList = new ArrayList();
            //得到UserId
            int userId = Integer.parseInt(request.getHeader("token"));
            //得到价格
            Float mTotalPrice = req.getTotalPrice();
            List<SubmitCartReq.CartGoodsBean> cartGoods = req.getCartGoods();

            OrderInfo orderBean = new OrderInfo();
            orderBean.setUserid(userId);
            orderBean.setPaytype(0);
            orderBean.setTotalprice(YuanFenConverter.changeY2FWJ(mTotalPrice));
            orderBean.setOrderstatus(1); //待支付状态
            ShipAddre shipAddre = shipService.getShip(userId);

            //购物地址id
            if(shipAddre!=null){
                orderBean.setShipid(shipAddre.getShipid());
            }else{
                //默认为0 当没有地址的时候
                orderBean.setShipid(0);
            }

            int orderId = orderService.insetSubmitCart(orderBean);

            if(orderId==0){
                resp.setCode(StatusCode.CODE_ERROR);
                resp.setMessage("获取失败");
                return resp;
            }

            if(orderId>0){
                boolean a = false;
                //插入到订单商品购物车里面的数据
                for(SubmitCartReq.CartGoodsBean sccg:cartGoods) {
                    //插到订单商品表中
                    cartIdList.add(sccg.getCartid());

                    OrderGoods goods = new OrderGoods();
                    goods.setUserid(userId);
                    goods.setGoodsid(sccg.getGoodsid());
                    goods.setOrderinfoid(orderBean.getOrderinfoid());
                    goods.setGoodsprice(YuanFenConverter.changeY2FWJ(sccg.getGoodsprice()));
                    goods.setGoodscount(sccg.getGoodscount());
                    goods.setGoodsdesc(sccg.getGoodsdesc());
                    goods.setGoodsicon(sccg.getGoodsicon());
                    goods.setGoodssku(sccg.getGoodssku());

                    int insertOk = orderService.insetOrderGoods(goods);

                    if(insertOk>0){
                        a = true;
                    }else{
                        a = false;
                    }
                }

                if(!a){
                    resp.setCode(StatusCode.CODE_ERROR);
                    resp.setMessage("获取失败");
                    return resp;
                }
            }

            InitAction.cartIdMap.put(Integer.valueOf(orderId), cartIdList);
            resp.setCode(StatusCode.CODE_SUCCESS);
            resp.setMessage("提交成功");
            resp.setData(orderId);
            return resp;

        }catch (Exception e){
            logger.error("Error",e);
            e.printStackTrace();
            resp.setCode(StatusCode.CODE_SERVER_ERROR);
            resp.setMessage("服务器错误");
            return resp;
        }
    }



}
