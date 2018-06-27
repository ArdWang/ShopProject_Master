package com.shop.controller;

import com.shop.domain.BaseResp;
import com.shop.domain.pay.GetSignReq;
import com.shop.utils.pay.PaySignUtils;
import com.shop.utils.util.StatusCode;
import com.shop.utils.util.YuanFenConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(produces = {"application/json; charset=UTF-8"}, value = {"/pay"})
public class PayController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(PayController.class);

    @RequestMapping(value = {"/getPaySign"}, method = {RequestMethod.POST})
    @ResponseBody
    public BaseResp<String> getPaySign(@RequestBody GetSignReq req) {
        BaseResp resp = new BaseResp();
        try {

            Float totalPrice = req.getTotalPrice();
            Integer orderId = req.getOrderId();

            String mMoney = PaySignUtils.sign(YuanFenConverter.changeY2FSG(totalPrice),orderId+"");

            if((mMoney==null)||(mMoney.isEmpty())){
                resp.setCode(StatusCode.CODE_ERROR);
                resp.setMessage("下单失败");
                return resp;
            }

            resp.setCode(StatusCode.CODE_SUCCESS);
            resp.setMessage("下单成功");
            resp.setData(mMoney);
            return resp;

        } catch (Exception e) {
            logger.error("Error",e);
            e.printStackTrace();
            resp.setCode(StatusCode.CODE_SERVER_ERROR);
            resp.setMessage("服务器错误");
            return resp;
        }
    }

}
