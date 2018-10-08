package com.ssm.aoptest;

import com.ssm.datasource.DataSourceType;

import java.lang.annotation.*;

/**
 * @author zongqi.hao@hand-china.com
 * @version 1.0
 * @name UseDataSource
 * @description ${DESCRIPTION}
 * @date 2018-09-28
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DynamicSwitchDataSource {

    /**
     * 数据源
     *
     * @return
     */
    DataSourceType dataSource() default DataSourceType.dataSource1;

//    /**
//     * 是否使用hashkey,若为true,则使用对应字段的哈希值进行计算，选择数据源，
//     * 且指定的{@link DataSourceType}不起作用
//     *
//     * @return
//     */
//    boolean useHashKey() default false;

}
