package com.ssm.util;

import java.io.Serializable;

/**
 * @author zongqi.hao@hand-china.com
 * @version 1.0
 * @name BasicModel
 * @description
 * @date 2018-07-22
 */
public class BasicModel implements Serializable {

    //已知数据
    //当前页
    private Integer pageNum;
    //每页显示的条数
    private Integer pageSize;
    //总记录数
    private Integer totalRecord;

    //需计算数据
    //总页数
    private Integer totalPage;
    //开始索引
    private Integer startIndex;

    //分页显示的页数,比如在页面上显示1，2，3，4，5页，start就为1，end就为5，这个也是算过来的
    private int start;
    private int end;


}
