package com.shop.utils.push;

import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.Notification;

public class PushSender {
    private static final String MASTER_SECRET = "e32076aa06330f146a2a7632";
    private static final String APP_KEY = "08cbeec1f4ef52aa1f790d42";
    private static JPushClient jpushClient = new JPushClient("e32076aa06330f146a2a7632", "08cbeec1f4ef52aa1f790d42", null, ClientConfig.getInstance());

    public static void sendLoginEvent(String pushId) {
        try {
            PushResult localPushResult = jpushClient.sendPush(buildLoginObject(pushId));
        } catch (APIConnectionException e) {
            e.printStackTrace();
        } catch (APIRequestException e) {
            e.printStackTrace();
        }
    }

    public static PushPayload buildLoginObject(String pushId) {
        return PushPayload.newBuilder()
                .setPlatform(Platform.android_ios())
                .setAudience(Audience.registrationId(new String[]{pushId}))
                .setMessage(Message.newBuilder()
                        .setMsgContent("登录成功")
                        .addExtra("code",
                                Integer.valueOf(1))
                        .build())
                .build();
    }

    public static void sendOrderEvent(String pushId, String orderId) {
        try {
            PushResult localPushResult = jpushClient.sendPush(buildOrderObject(pushId, orderId));
        } catch (APIConnectionException e) {
            e.printStackTrace();
        } catch (APIRequestException e) {
            e.printStackTrace();
        }
    }

    public static PushPayload buildOrderObject(String pushId, String orderId) {
        return PushPayload.newBuilder()
                .setPlatform(Platform.android_ios())
                .setAudience(Audience.registrationId(new String[]{pushId}))
                .setNotification(Notification.newBuilder()
                        .addPlatformNotification(
                                (AndroidNotification.newBuilder()
                                        .setAlert("你的订单提交成功")
                                        .addExtra("orderId", orderId))
                                        .build())
                        .build())
                .build();
    }
}
