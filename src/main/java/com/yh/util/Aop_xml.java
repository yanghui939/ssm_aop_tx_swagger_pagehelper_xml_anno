package com.yh.util;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;

import java.util.Arrays;
import java.util.List;
@Slf4j
public class Aop_xml {

    public void before(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        List<Object> argList = Arrays.asList(joinPoint.getArgs());
        log.info("前置通知的方法名为：{}，参数为：{}",methodName,argList);
    }

    public void afterThrowing(JoinPoint joinPoint,Exception ex){
        String methodName = joinPoint.getSignature().getName();
        List<Object> argList = Arrays.asList(joinPoint.getArgs());
        log.info("异常通知的方法名为：{}，参数为：{}，异常为：{}",methodName,argList,ex);
    }
    public void afterReturning(JoinPoint joinPoint,Object result){
        String methodName = joinPoint.getSignature().getName();
        List<Object> argList = Arrays.asList(joinPoint.getArgs());
        log.info("后置通知的方法名为：{}，参数为：{}，返回为：{}",methodName,argList,result);
    }
    public void after(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        List<Object> argList = Arrays.asList(joinPoint.getArgs());
        log.info("最终通知的方法名为：{}，参数为：{}",methodName,argList);
    }
}
