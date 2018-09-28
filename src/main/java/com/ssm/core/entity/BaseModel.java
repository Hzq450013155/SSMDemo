package com.ssm.core.entity;

/**
 * @author zongqi.hao@hand-china.com
 * @version 1.0
 * @name BaseModel
 * @description
 * @date 2018-09-27
 */
public class BaseModel {

    private int pageNum;
    private int pageSize;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
