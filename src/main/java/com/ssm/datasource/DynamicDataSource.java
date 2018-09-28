package com.ssm.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.jdbc.datasource.lookup.DataSourceLookup;

import java.util.Map;

/**
 * @author zongqi.hao@hand-china.com
 * @version 1.0
 * @name RoutingDataSource
 * @description
 * @date 2018-09-09
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        DataSourceType dataSourceType = DataSourceHolder.getDataSourceType();
        return dataSourceType;
    }


    public void setDataSourceLookup(DataSourceLookup dataSourceLookup) {
        super.setDataSourceLookup(dataSourceLookup);
    }


    public void setDefaultTargetDataSource(Object defaultTargetDataSource) {
        super.setDefaultTargetDataSource(defaultTargetDataSource);
    }


    public void setTargetDataSources(Map targetDataSources) {
        super.setTargetDataSources(targetDataSources);
    }
}
