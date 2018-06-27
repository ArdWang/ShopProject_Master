package com.shop.utils.util;
import com.shop.controller.CartController;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
public class FtpFileUtil {
    //ftp服务器ip地址
    private static final String FTP_ADDRESS = "119.23.223.146";
    //端口号
    private static final int FTP_PORT = 21;
    //用户名
    private static final String FTP_USERNAME = "admin";
    //密码
    private static final String FTP_PASSWORD = "123456";
    //图片路径
    private static final String FTP_BASEPATH = "E:/ftpfile";

    private static final Logger logger = LoggerFactory.getLogger(FtpFileUtil.class);

    public  static boolean uploadFile(String originFileName,InputStream input){
        boolean success = false;
        FTPClient ftp = new FTPClient();
        ftp.setControlEncoding("UTF-8");
        try {
            int reply;
            ftp.connect(FTP_ADDRESS, FTP_PORT);// 连接FTP服务器
            ftp.login(FTP_USERNAME, FTP_PASSWORD);// 登录
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return success;
            }
            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftp.makeDirectory(FTP_BASEPATH );
            ftp.changeWorkingDirectory(FTP_BASEPATH );
            //这个方法的意思就是每次数据连接之前，ftp client告诉ftp server开通一个端口来传输数据。
            //为什么要这样做呢，因为ftp server可能每次开启不同的端口来传输数据，但是在linux上或者其他服务器上面，
            //由于安全限制，可能某些端口没有开启，所以就出现阻塞。
            ftp.enterLocalPassiveMode();
            ftp.setRemoteVerificationEnabled(false);
            ftp.changeWorkingDirectory(originFileName);// 转移到FTP服务器目录
            ftp.storeFile(originFileName,input);
            input.close();
            ftp.logout();
            success = true;
        } catch (IOException e) {
            logger.error("Error",e);
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                    logger.error("Error",ioe);
                }
            }
        }
        return success;
    }
}
