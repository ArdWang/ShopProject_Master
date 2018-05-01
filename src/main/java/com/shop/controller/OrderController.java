package com.shop.controller;


import com.shop.common.InitAction;
import com.shop.domain.order.*;
import com.shop.model.msg.MsgInfo;
import com.shop.model.order.OrderInfo;
import com.shop.model.order.OrderResp;
import com.shop.model.order.Orders;
import com.shop.model.user.User;
import com.shop.service.CartService;
import com.shop.service.MsgService;
import com.shop.service.OrderService;
import com.shop.service.UserService;
import com.shop.domain.BaseResp;
import com.shop.utils.push.PushSender;
import com.shop.utils.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping(produces = {"application/json;charset=UTF-8"}, value = {"/order"})
public class OrderController extends BaseController{

    @Autowired
    private OrderService orderService;

    @Autowired
    private CartService cartService;

    @Autowired
    private MsgService msgService;

    @Autowired
    private UserService userService;

    /**
     * 根据订单状态获取状态
     */
    @RequestMapping(value = {"/getOrderList"}, method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public OrderResp getOrderList(@RequestBody GetAllOrderReq req){
        OrderResp resp = new OrderResp();
        try {
            List<Orders> ordersList;
            int userId = Integer.parseInt(request.getHeader("token"));
            int orderStatus = req.getOrderStatus();
            if (orderStatus == 0) {
                ordersList = orderService.getOrderListAll(userId, orderStatus);
            } else {
                ordersList = orderService.getOrderList(userId, orderStatus);
            }

            if ((ordersList == null) || (ordersList.size() == 0)) {
                resp.setCode(StatusCode.CODE_ERROR);
                resp.setMessage("列表为空");
                resp.setOrders(null);
                return resp;
            }

            resp.setCode(StatusCode.CODE_SUCCESS);
            resp.setMessage("获取成功");
            resp.setOrders(ordersList);
            return resp;
        }catch (Exception e){
            e.printStackTrace();
            resp.setCode(StatusCode.CODE_SERVER_ERROR);
            resp.setMessage("服务器错误");
            resp.setOrders(null);
            return resp;
        }

    }

    /**
     * 根据订单ID得到商品的订单信息
     */
    @RequestMapping(value = {"/getOrderById"}, method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public BaseResp<Orders> getOrder(@RequestBody OrderByIdReq req){
        BaseResp resp  = new BaseResp();
        try {
            //得到UserId
            int userId = Integer.parseInt(request.getHeader("token"));
            int orderId = req.getOrderId();

            if(userId==0||orderId==0){
                resp.setCode(StatusCode.CODE_ERROR);
                resp.setMessage("订单信息为空");
                return resp;
            }

            Map<Object, Object> params = new HashMap<>();
            params.put("userid", userId);
            params.put("orderinfoid", orderId);

            Orders orders = orderService.getOrder(params);

            if (orders == null) {
                resp.setCode(StatusCode.CODE_ERROR);
                resp.setMessage("订单信息为空");
                return resp;
            }

            resp.setCode(StatusCode.CODE_SUCCESS);
            resp.setMessage("获取订单成功");
            resp.setData(orders);
            return resp;

        }catch (Exception e){
            e.printStackTrace();
            resp.setCode(StatusCode.CODE_SERVER_ERROR);
            resp.setMessage("服务器错误");
            return resp;
        }
    }

    /**
     * 提交订单
     */
    @RequestMapping(value = {"/submitOrder"}, method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public BaseResp submitOrder(@RequestBody SubmitOrderReq req){
        BaseResp resp = new BaseResp();
        try{
            //得到UserId
            int userId = Integer.parseInt(request.getHeader("token"));

            OrderInfo orderInfo = new OrderInfo();

            orderInfo.setShipid(req.getOrders().getShipAddre().getShipid());
            orderInfo.setUserid(userId);
            orderInfo.setTotalprice(YuanFenConverter.changeY2FWJ(req.getOrders().getTotalPrice()));
            orderInfo.setOrderstatus(req.getOrders().getOrderStatus());
            orderInfo.setPaytype(req.getOrders().getPayType());
            orderInfo.setOrderinfoid(req.getOrders().getOrderId());

            int updateOk = orderService.updateOrderInfo(orderInfo);

            List<Integer> cartIdList = InitAction.cartIdMap.get(req.getOrders().getOrderId());

            boolean deleteCart = cartService.deleteCart(cartIdList,userId);

            //提交订单失败
            if(!deleteCart){
                resp.setCode(StatusCode.CODE_ERROR);
                resp.setMessage("提交订单失败");
                return resp;
            }

            InitAction.cartIdMap.remove(req.getOrders().getOrderId());

            if(updateOk==0){
                resp.setCode(StatusCode.CODE_ERROR);
                resp.setMessage("提交订单失败");
                return resp;
            }

            //提交订单信息
            addMsg(userId,1,"订单待支付","订单编号为"+req.getOrders().getOrderId()+"已经成功下单，等待你的支付");
            sendNofiaction(userId,req.getOrders().getOrderId());

            resp.setCode(StatusCode.CODE_SUCCESS);
            resp.setMessage("提交订单成功");
            return resp;

        }catch (Exception e){
            e.printStackTrace();
            resp.setCode(StatusCode.CODE_SERVER_ERROR);
            resp.setMessage("服务器错误");
            return resp;
        }
    }

    /**
        确认订单
     */
    @RequestMapping(value = {"/confirmOrder"}, method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public BaseResp confirmOrder(@RequestBody ConfrimOrderReq req){
        BaseResp resp = new BaseResp();
        try {
            int userId = Integer.parseInt(request.getHeader("token"));
            int orderId = req.getOrderId();

            Map<Object,Object> params = new HashMap<>();

            params.put("userid",userId);
            params.put("orderinfoid",orderId);
            params.put("orderstatus",3);

            int updateStatus = orderService.updateOrderStatus(params);

            if(updateStatus==0){
                resp.setCode(StatusCode.CODE_ERROR);
                resp.setMessage("确认订单失败");
                return resp;
            }

            addMsg(userId,3,"订单收货成功","订单编号为"+orderId+"订单已经成功收货。感谢你的购买");

            resp.setCode(StatusCode.CODE_SUCCESS);
            resp.setMessage("确认订单成功");
            return resp;

        }catch (Exception e){
            e.printStackTrace();
            resp.setCode(StatusCode.CODE_SERVER_ERROR);
            resp.setMessage("服务器错误");
            return resp;
        }
    }

    @RequestMapping(value = {"/payOrder"}, method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public BaseResp payOrder(@RequestBody PayOrderReq req){
        BaseResp resp = new BaseResp();
        try{
            int userId = Integer.parseInt(request.getHeader("token"));
            int orderId = req.getOrderId();
            Map<Object,Object> params = new HashMap<>();

            params.put("userid",userId);
            params.put("orderinfoid",orderId);
            params.put("orderstatus",2);

            int updateStatus = orderService.updateOrderStatus(params);

            if(updateStatus==0){
                resp.setCode(StatusCode.CODE_ERROR);
                resp.setMessage("支付订单失败");
                return resp;
            }

            addMsg(userId,2,"订单购买成功","订单编号为"+orderId+"订单已经付款。请你等待收货");

            resp.setCode(StatusCode.CODE_SUCCESS);
            resp.setMessage("购买成功");
            return resp;

        }catch (Exception e){
            e.printStackTrace();
            resp.setCode(StatusCode.CODE_SERVER_ERROR);
            resp.setMessage("服务器错误");
            return resp;
        }
    }

    /**
        取消订单
     */
    @RequestMapping(value = {"/cancelOrder"}, method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public BaseResp cancelOrder(@RequestBody CancelOrderReq req){
        BaseResp resp = new BaseResp();
        try {
            int userId = Integer.parseInt(request.getHeader("token"));
            int orderId = req.getOrderId();

            Map<Object,Object> params = new HashMap<>();

            params.put("userid",userId);
            params.put("orderinfoid",orderId);
            params.put("orderstatus",4);

            int updateStatus = orderService.updateOrderStatus(params);

            if(updateStatus == 0){
                resp.setCode(StatusCode.CODE_ERROR);
                resp.setMessage("取消订单失败");
                return resp;
            }

            addMsg(userId,4,"订单取消成功","订单编号为"+orderId+"订单已经成功取消");

            resp.setCode(StatusCode.CODE_SUCCESS);
            resp.setMessage("取消订单成功");
            return resp;

        }catch (Exception e){
            e.printStackTrace();
            resp.setCode(StatusCode.CODE_SERVER_ERROR);
            resp.setMessage("服务器错误");
            return resp;
        }
    }


    public void sendNofiaction(int userId,int orderId){
        User user = userService.getUserData(userId);
        if(user!=null){
            PushSender.sendOrderEvent(user.getPushid(),orderId+"");
        }
    }

    /**
     *
     * 添加消息到消息中心中去
     */
    private void addMsg(int userId,int msgType,String msgtitle,String msgcon) {
        MsgInfo msgInfo = new MsgInfo();
        try {
            msgInfo.setUserid(userId);
            //用户为0
            msgInfo.setMsgtype(msgType);

            msgInfo.setMsgtitle(msgtitle);

            msgInfo.setMsgcon(msgcon);

            msgInfo.setMsgimg("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1524634520520&di=d2f91c9eb61eed84c962f78a9caf85d0&imgtype=0&src=http%3A%2F%2Fwww.qqzhi.com%2Fuploadpic%2F2015-01-27%2F121838355.jpg");

            Date date = new Date(System.currentTimeMillis());
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            date = df.parse(df.format(date));

            msgInfo.setMsgtime(date);

            //默认为0 未读消息
            msgInfo.setMsgread(0);

            int insertMsg = msgService.insertMessage(msgInfo);

            if (insertMsg > 0) {
                System.out.println("插入登录消息成功");
            } else {
                System.out.println("插入登录消息失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
