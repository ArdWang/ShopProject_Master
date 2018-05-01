package com.shop.utils.util;

import com.github.pagehelper.PageInfo;

import java.util.List;

public class PageInfos<T> extends PageInfo<T>{
    private List<T> list;
    public PageInfos(List<T> list){
        this.list = list;
    }
}
