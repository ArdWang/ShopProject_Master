package com.shop.domain.goods;

public class GetGoodsInfoReq {
    private Integer categorypid;

    public Integer getCategorypid() {
        return categorypid;
    }

    public void setCategorypid(Integer categorypid) {
        this.categorypid = categorypid;
    }

    public Integer getCategorysid() {
        return categorysid;
    }

    public void setCategorysid(Integer categorysid) {
        this.categorysid = categorysid;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    private Integer categorysid;
    private Integer pageIndex;
    private Integer pageSize;
}
