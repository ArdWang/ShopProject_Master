package com.shop.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    携带其它的参数类
 */
public class InitAction {

    public static Map<Integer, List<Integer>> cartIdMap;

    public static void init() {
        cartIdMap = new HashMap();
    }
}