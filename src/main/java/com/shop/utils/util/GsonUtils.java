package com.shop.utils.util;

import com.google.gson.Gson;

public class GsonUtils {
    /**
     * 解析成json 谷歌的解析强大介意用谷歌的Gson
     * @param object
     * @return
     */
    public static String toJson(Object object) {
        if (object == null) {
            return "";
        }
        Gson gson = new Gson();
        try {
            return gson.toJson(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
