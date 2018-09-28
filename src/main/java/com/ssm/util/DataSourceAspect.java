//package com.ssm.util;
//
//import java.lang.reflect.Method;
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.AfterReturning;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Repository;
///**
// * @author zongqi.hao@hand-china.com
// * @version 1.0
// * @name DataSourceAspect
// * @description
// * @date 2018-09-09
// */
//@Order(1)
//@Aspect
//@Repository
//public class DataSourceAspect {
//    @Pointcut("execution(* com..*Impl.*(..))")
//    private void anyMethod() {
//    }
//
//    @AfterReturning(value = "anyMethod()", returning = "result")
//    public void afterReturning(JoinPoint joinPoint, Object result){
//        DataSourceHolder.clearDataSourceType();
//    }
//
//    @Before(value="anyMethod()")
//    public void before(JoinPoint joinPoint) throws Throwable {
//        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
//        Method method = methodSignature.getMethod();
//        //如果方法体上使用了DataSource注解
//        if (method.isAnnotationPresent(DataSource.class)) {
//            //获取该方法上的注解名
//            DataSource datasource = method.getAnnotation(DataSource.class);
//            //将方法体上的注解的值赋予给DataSourceHolder数据源持有类
//            DataSourceHolder.setDataSourceType(datasource.value());
//        }
//    }
//}
