package com.shop.controller;


import com.shop.domain.user.*;
import com.shop.model.msg.MsgInfo;
import com.shop.model.user.User;
import com.shop.service.MsgService;
import com.shop.service.UserService;
import com.shop.domain.BaseResp;
import com.shop.utils.push.PushSender;
import com.shop.utils.util.StatusCode;
import com.sun.org.glassfish.external.statistics.annotations.Reset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(produces = {"application/json;charset=UTF-8"}, value = {"/user"})
public class UserController extends BaseController{

    @Autowired
    private UserService userService;

    @Autowired
    private MsgService msgService;

    /**
     * 得到用户信息
     */
    @RequestMapping(value = {"/getUser"}, method = {RequestMethod.POST})
    @ResponseBody
    public BaseResp<User> getUser(@RequestBody GetUserReq req){
        BaseResp resp = new BaseResp();
        try {
            String phone = req.getPhone();
            String passWord = req.getPassword();
            String pushId = req.getPushid();

            //检查不能为空值 空值就为错误
            if (phone == null || passWord == null) {
                resp.setCode(StatusCode.CODE_ERROR);
                resp.setMessage("输入不能为空");
                return resp;
            }

            Map<Object, Object> params = new HashMap<>();
            params.put("phone", phone);
            params.put("password", passWord);

            User user = userService.getUser(params);

            if (user == null) {
                resp.setCode(StatusCode.CODE_ERROR);
                resp.setMessage("帐号或者密码错误");
                return resp;
            }

            addMsg(user.getUserid(), user.getUsername() + "你已经成功登录", user.getUserimg());
            //不为空的时候执行
            if(pushId!=null&&!pushId.isEmpty()) {
                Map<Object, Object> params1 = new HashMap<>();
                params1.put("userid", user.getUserid());
                params1.put("pushid", pushId);
                int ss = userService.editPushid(params1);
                if (ss > 0) {
                    System.out.println("修该pushid成功");
                    sendNotication(pushId);
                }
            }

            resp.setCode(StatusCode.CODE_SUCCESS);
            resp.setMessage("获取成功");
            resp.setData(user);
            return resp;

        }catch (Exception e){
            e.printStackTrace();
            resp.setCode(StatusCode.CODE_SERVER_ERROR);
            resp.setMessage("服务器错误");
            return resp;
        }
    }

    @RequestMapping(value = {"/regUser"}, method = {RequestMethod.POST})
    @ResponseBody
    public BaseResp regUser(@RequestBody RegUserReq req){
        BaseResp resp = new BaseResp();
        try{
            String moblie = req.getMobile();
            String password = req.getPassword();
            String verifyCode = req.getVerifyCode();

            if(moblie==null||password==null||verifyCode==null){
                resp.setCode(StatusCode.CODE_ERROR);
                resp.setMessage("参数不能为空");
                return resp;
            }

            if(!verifyCode.equals("123456")){
                resp.setCode(StatusCode.CODE_ERROR);
                resp.setMessage("验证码错误");
                return resp;
            }

            int queryUser = userService.queryUser(moblie);

            if(queryUser>0){
                resp.setCode(StatusCode.CODE_ERROR);
                resp.setMessage("用户已被注册");
                return resp;
            }

            //添加的时候用户名一样的添加
            Map<Object, Object> params = new HashMap<>();
            params.put("phone", moblie);
            params.put("password", password);
            params.put("username",moblie);

            int addUser = userService.addUser(params);

            if(addUser==0){
                resp.setCode(StatusCode.CODE_ERROR);
                resp.setMessage("用户注册失败");
                return resp;
            }

            resp.setCode(StatusCode.CODE_SUCCESS);
            resp.setMessage("用户注册成功");
            return resp;
        }catch (Exception e){
            e.printStackTrace();
            resp.setCode(StatusCode.CODE_SERVER_ERROR);
            resp.setMessage("服务器错误");
            return resp;
        }
    }

    @RequestMapping(value = {"/forgetPwd"}, method = {RequestMethod.POST})
    @ResponseBody
    public BaseResp forgetPwd(@RequestBody ForgetPwdReq req){
        BaseResp resp = new BaseResp();
        try{
            String mobile = req.getMobile();
            String verifyCode = req.getVerifyCode();

            if(mobile==null||verifyCode==null){
                resp.setCode(StatusCode.CODE_ERROR);
                resp.setMessage("参数不能为空");
                return resp;
            }

            if(!verifyCode.equals("123456")){
                resp.setCode(StatusCode.CODE_ERROR);
                resp.setMessage("验证码错误");
                return resp;
            }

            int queryUser = userService.queryUser(mobile);

            if(queryUser==0){
                resp.setCode(StatusCode.CODE_ERROR);
                resp.setMessage("用户不存在");
                return resp;
            }

            resp.setCode(StatusCode.CODE_SUCCESS);
            resp.setMessage("用户已经找到");
            return resp;

        }catch (Exception e){
            e.printStackTrace();
            resp.setCode(StatusCode.CODE_SERVER_ERROR);
            resp.setMessage("服务器错误");
            return resp;
        }
    }


    @RequestMapping(value = {"/resetPwd"}, method = {RequestMethod.POST})
    @ResponseBody
    public BaseResp resetPwd(@RequestBody ResetPwdReq req){
        BaseResp resp = new BaseResp();
        try{
            String mobile = req.getMobile();
            String password = req.getPassword();

            if(mobile==null||password==null){
                resp.setCode(StatusCode.CODE_ERROR);
                resp.setMessage("参数不能为空");
                return resp;
            }

            Map<Object, Object> params = new HashMap<>();
            params.put("phone", mobile);
            params.put("password", password);

            int restPwd = userService.resetPwd(params);

            if(restPwd==0){
                resp.setCode(StatusCode.CODE_ERROR);
                resp.setMessage("重置密码失败");
                return resp;
            }

            resp.setCode(StatusCode.CODE_SUCCESS);
            resp.setMessage("重置密码成功");
            return resp;

        }catch (Exception e){
            e.printStackTrace();
            resp.setCode(StatusCode.CODE_SERVER_ERROR);
            resp.setMessage("服务器错误");
            return resp;
        }
    }

    @RequestMapping(value = {"/editUser"}, method = {RequestMethod.POST})
    @ResponseBody
    public BaseResp<User> editUser(@RequestBody EditUserReq req){
        BaseResp resp = new BaseResp();
        try{
            int userId = req.getUserid();
            String userName = req.getUsername();
            String userImg = req.getUserimg();
            int sex = req.getSex();
            String sign = req.getSign();

            Map<Object,Object> params = new HashMap<>();
            params.put("userid",userId);
            params.put("username",userName);
            params.put("userimg",userImg);
            params.put("sex",sex);
            params.put("sign",sign);

            User user = userService.editUser(params);

            if(user==null){
                resp.setCode(StatusCode.CODE_ERROR);
                resp.setMessage("编辑失败");
                return resp;
            }

            resp.setCode(StatusCode.CODE_SUCCESS);
            resp.setMessage("编辑成功");
            resp.setData(user);
            return resp;
        }catch (Exception e){
            e.printStackTrace();
            resp.setCode(StatusCode.CODE_SERVER_ERROR);
            resp.setMessage("服务器错误");
            return resp;
        }
    }


    public void sendNotication(String pushId){
        if(!pushId.equals("")) {
            PushSender.sendLoginEvent(pushId);
        }
    }

    /**
     * 添加消息到消息中心中去
     */
    private void addMsg(int userId,String msgcon,String msgImg) {
        MsgInfo msgInfo = new MsgInfo();
        try {

            msgInfo.setUserid(userId);
            //用户为0
            msgInfo.setMsgtype(0);
            msgInfo.setMsgtitle("用户登录成功");
            msgInfo.setMsgcon(msgcon);
            if (msgImg != null) {
                msgInfo.setMsgimg(msgImg);
            } else {
                msgInfo.setMsgimg("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1524634520520&di=d2f91c9eb61eed84c962f78a9caf85d0&imgtype=0&src=http%3A%2F%2Fwww.qqzhi.com%2Fuploadpic%2F2015-01-27%2F121838355.jpg");
            }

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
