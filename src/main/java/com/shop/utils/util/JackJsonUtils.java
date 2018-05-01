package com.shop.utils.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JackJsonUtils {
	static ObjectMapper objectMapper;
    /**  
     *  
     * @param content 
     * @param valueType 
     * @return 
     */  
    public static <T> T fromJson(String content, Class<T> valueType) {  
        if (objectMapper == null) {  
            objectMapper = new ObjectMapper();  
        }  
        try {  
            return objectMapper.readValue(content, valueType);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return null;  
    }  
  
    /** 
     *  
     * @param object 
     * @return 
     */  
    public static String toJson(Object object) {  
        if (objectMapper == null) {  
            objectMapper =new ObjectMapper().disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        }  
        try {  
            return objectMapper.writeValueAsString(object);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return null;  
    }  
}
