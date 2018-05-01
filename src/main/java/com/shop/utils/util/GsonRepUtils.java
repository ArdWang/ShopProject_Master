package com.shop.utils.util;

import com.google.gson.Gson;

public class GsonRepUtils {
    public static String toJson(Object object){
        if(object!=null){
            Gson gson = new Gson();
            try {
                return gson.toJson(object);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
        return null;
    }
}
