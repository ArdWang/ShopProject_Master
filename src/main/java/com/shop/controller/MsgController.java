package com.shop.controller;


import com.github.pagehelper.PageHelper;
import com.shop.domain.BaseResp;
import com.shop.domain.msg.GetMsgReq;
import com.shop.domain.msg.UpdateMsgReq;
import com.shop.model.msg.MsgInfo;
import com.shop.model.msg.MsgInfoResp;
import com.shop.service.MsgService;
import com.shop.utils.util.StatusCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping(produces = {"application/json;charset=UTF-8"}, value = {"/message"})
public class MsgController extends BaseController{

    @Autowired
    private MsgService msgService;

    private static final Logger logger = LoggerFactory.getLogger(MsgController.class);

    @RequestMapping(value = {"/getMessage"}, method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public MsgInfoResp getMessage(@RequestBody GetMsgReq req){
        MsgInfoResp resp = new MsgInfoResp();
        try{
            int pageIndex = Integer.parseInt(req.getPageIndex());
            int pageSize = Integer.parseInt(req.getPageSize());
            int userId = Integer.parseInt(request.getHeader("token"));

            PageHelper.startPage(pageIndex,pageSize);
            List<MsgInfo> msgInfos = msgService.getMessage(userId);

            if((msgInfos==null)||(msgInfos.size()==0)){
                resp.setCode(StatusCode.CODE_ERROR);
                resp.setMessage("获取消息失败");
                resp.setMsgInfos(null);
                return resp;
            }

            resp.setCode(StatusCode.CODE_SUCCESS);
            resp.setMessage("获取消息成功");
            resp.setMsgInfos(msgInfos);
            return resp;

        }catch (Exception e){
            logger.error("Error",e);
            e.printStackTrace();
            resp.setCode(StatusCode.CODE_SERVER_ERROR);
            resp.setMessage("服务器错误");
            resp.setMsgInfos(null);
            return resp;
        }
    }

    @RequestMapping(value = {"/updateMessage"}, method = {RequestMethod.POST})
    @ResponseBody
    public BaseResp updateMessage(@RequestBody UpdateMsgReq req){
        BaseResp resp = new BaseResp();
        try{String userData = request.getHeader("token");
            if(userData.isEmpty()){
                resp.setCode(StatusCode.CODE_ERROR);
                resp.setMessage("用户token不能为空");
                return resp;
            }
            int userId = Integer.parseInt(userData);

            int msgId = req.getMsgId();
            int msgRead = req.getMsgRead();

            Map<Object,Object> params = new HashMap<>();
            params.put("userid",userId);
            params.put("msgid",msgId);
            params.put("msgread",msgRead);

            int updateMsg = msgService.updateMessage(params);

            if(updateMsg==0){
                resp.setCode(StatusCode.CODE_ERROR);
                resp.setMessage("更新消息失败");
                return resp;
            }

            resp.setCode(StatusCode.CODE_SUCCESS);
            resp.setMessage("更新消息成功");
            return resp;

        }catch (Exception e){
            logger.error("Error",e);
            e.printStackTrace();
            resp.setCode(StatusCode.CODE_SERVER_ERROR);
            resp.setMessage("服务器错误");
            return resp;
        }
    }


    @RequestMapping(value = {"/deleteMessage"}, method = {RequestMethod.POST})
    @ResponseBody
    public BaseResp deleteMessage(@RequestBody com.shop.domain.domain.msg.DeleteMsgReq req){
        BaseResp resp = new BaseResp();
        try{
            String userData = request.getHeader("token");
            if(userData.isEmpty()){
                resp.setCode(StatusCode.CODE_ERROR);
                resp.setMessage("用户token不能为空");
                return resp;
            }
            int userId = Integer.parseInt(userData);

            int msgId = req.getMsgId();

            Map<Object,Object> params = new HashMap<>();

            params.put("userid",userId);
            params.put("msgid",msgId);

            int deleteMsg = msgService.deleteMessage(params);

            if(deleteMsg==0){
                resp.setCode(StatusCode.CODE_ERROR);
                resp.setMessage("删除消息失败");
                return resp;
            }

            resp.setCode(StatusCode.CODE_SUCCESS);
            resp.setMessage("删除消息成功");
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
