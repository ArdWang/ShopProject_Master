package com.shop.controller;

import com.qiniu.util.Auth;
import com.shop.domain.BaseResp;
import com.shop.utils.util.StatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(produces = {"application/json;charset=UTF-8"}, value = {"/common"})
public class UploadController {

    @RequestMapping(value = {"/getUploadToken"}, method = {RequestMethod.POST})
    @ResponseBody
    public BaseResp<String> uploadData(){
        BaseResp resp = new BaseResp();
        try {
            String accessKey = "XupM6oc62hHkSX7ZUbZfOdRh-VziIayTL8G0G6Gd";
            String secretKey = "Vk6BXJDx0z6A9cUA-6KyeIC4ZiUHLQ3DFV08J71L";
            //云名称
            String bucket = "shopimage";
            Auth auth = Auth.create(accessKey, secretKey);
            String upToken = auth.uploadToken(bucket);
            //System.out.println(upToken);

            if (upToken == null) {
                resp.setCode(StatusCode.CODE_ERROR);
                resp.setMessage("上传错误");
                return resp;
            }

            resp.setCode(StatusCode.CODE_SUCCESS);
            resp.setMessage("获取成功");
            resp.setData(upToken);
            return resp;
        }catch (Exception e){
            e.printStackTrace();
            resp.setCode(StatusCode.CODE_SERVER_ERROR);
            resp.setMessage("服务器错误");
            return resp;
        }
    }
}
