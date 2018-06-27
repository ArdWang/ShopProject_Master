package com.shop.controller;

import com.shop.domain.BaseResp;
import com.shop.model.ftp.FtpInfo;
import com.shop.utils.util.FtpFileUtil;
import com.shop.utils.util.StatusCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.rmi.server.ExportException;

@Controller
public class FtpFileUploadController extends BaseController{

    private static final Logger logger = LoggerFactory.getLogger(FtpFileUploadController.class);

    //ftp处理文件上传
    @RequestMapping(value="/ftpupload", method = RequestMethod.POST)
    @ResponseBody
    public BaseResp<FtpInfo> uploadImg(@RequestParam("file") MultipartFile file,
                                       HttpServletRequest request) throws IOException {
        BaseResp resp = new BaseResp();
        try {
            String fileName = file.getOriginalFilename();
            InputStream inputStream = file.getInputStream();
            //String filePath=null;

            Boolean flag = FtpFileUtil.uploadFile(fileName, inputStream);
            if (flag == false) {
                resp.setCode(StatusCode.CODE_ERROR);
                resp.setMessage("上传文件失败");
                return resp;
                //System.out.println("ftp上传成功！");
                //filePath=fileName;
            }
            System.out.println("ftp上传成功！");
            //filePath = fileName;
            resp.setCode(StatusCode.CODE_SUCCESS);
            resp.setMessage("获取成功");
            resp.setData("http://www.riltemp.club:8089/" + fileName);
            return resp;
        }catch (ExportException e){
            logger.error("Error",e);
            e.printStackTrace();
            resp.setCode(StatusCode.CODE_ERROR);
            resp.setMessage("服务器错误");
            return resp;
        }
        //return  filePath;  //该路径图片名称，前端框架可用ngnix指定的路径+filePath,即可访问到ngnix图片服务器中的图片
    }

}
