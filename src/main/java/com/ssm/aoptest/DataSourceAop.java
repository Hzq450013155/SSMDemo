package com.ssm.aoptest;

import com.ssm.datasource.DataSourceHolder;
import com.ssm.datasource.DataSourceType;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


/**
 * @author zongqi.hao@hand-china.com
 * @version 1.0
 * @name DataSource
 * @description 数据源切换
 * @date 2018-09-28
 */
@Aspect
@Component
@Order(1)
public class DataSourceAop {
    private static final Logger logger = Logger.getLogger(DataSourceAop.class);

    @Pointcut("@within(com.ssm.aoptest.DynamicSwitchDataSource)||@annotation(com.ssm.aoptest.DynamicSwitchDataSource)")
    public void pointCut() {
    }

    //方法执行前通知
    @Before("pointCut()")
    public void before(JoinPoint joinPoint) {
        logger.info("执行查询待办列表getList方法");
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        DynamicSwitchDataSource annotationClass = method.getAnnotation(DynamicSwitchDataSource.class);//获取方法上的注解
        if (annotationClass == null) {
            annotationClass = joinPoint.getTarget().getClass().getAnnotation(DynamicSwitchDataSource.class);//获取类上面的注解
            if (annotationClass == null) return;
        }
        //获取注解上的数据源的值的信息
        DataSourceType dataSourceType = annotationClass.dataSource();
        if (dataSourceType != null) {
            //给当前的执行SQL的操作设置特殊的数据源的信息
            DataSourceHolder.setDataSourceType(dataSourceType);
        }
        logger.info("AOP动态切换数据源，className" + joinPoint.getTarget().getClass().getName() + "methodName" + method.getName() + ";dataSourceType:" + dataSourceType == "" ? "默认数据源" : dataSourceType.toString());

    }

    //方法执行后通知
    @After("pointCut()")
    public void after() {
        logger.info("方法执行完毕，清除datasource");
        DataSourceHolder.clearDataSourceType();
    }

    //方法成功执行完毕通知
    @AfterReturning("pointCut()")
    public void afterReturningLog() {
        logger.info("方法“成功”执行后通知 日志记录");
    }

    //    抛出异常后通知
    @AfterThrowing("pointCut()")
    public void afterThrowingLog() {
        logger.info("方法“抛出异常”后执行通知 日志记录");
    }


}
