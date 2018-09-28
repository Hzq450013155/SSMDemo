package com.ssm.datasource;

/**
 * @author zongqi.hao@hand-china.com
 * @version 1.0
 * @name DataSourceHolder
 * @description
 * @date 2018-09-09
 */
public class DataSourceHolder {

    private static final ThreadLocal contextHolder = new ThreadLocal();

    /**
     * @param dataSourceType 数据库类型
     * @return void
     * @throws
     * @Description: 设置数据源类型
     */
    public static void setDataSourceType(DataSourceType dataSourceType) {
        contextHolder.set(dataSourceType);
    }

    /**
     * @param
     * @return String
     * @throws
     * @Description: 获取数据源类型
     */
    public static DataSourceType getDataSourceType() {
        return (DataSourceType) contextHolder.get();
    }

    /**
     * @param
     * @return void
     * @throws
     * @Description: 清除数据源类型
     */
    public static void clearDataSourceType() {
        contextHolder.remove();
    }

}
