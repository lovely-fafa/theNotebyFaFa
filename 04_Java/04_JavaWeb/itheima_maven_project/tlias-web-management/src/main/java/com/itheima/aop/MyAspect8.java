package com.itheima.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Component
@Aspect
public class MyAspect8 {

    @Pointcut("execution(* com.itheima.service.DeptService.*(..))")
    private void pt(){}

    @Before("pt()")
    public void before(JoinPoint joinPoint) {
        log.info("MyAspect8 ... before");
    }

    @Around("pt()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("MyAspect8 around before");

        // 1. 获取 目标对象的类名
        String className = proceedingJoinPoint.getTarget().getClass().getName();
        log.info("目标对象的类名：{}", className);

        // 2. 获取 目标对象的方法名
        String methodName = proceedingJoinPoint.getSignature().getName();
        log.info("目标对象的方法名：{}", methodName);

        // 3. 获取 目标对象传入的参数
        Object[] args = proceedingJoinPoint.getArgs();
        log.info("目标对象传入的参数：{}", Arrays.toString(args));

        // 4. 放行 目标方法执行结果
        Object result = proceedingJoinPoint.proceed();

        // 5. 获取 目标方法执行结果
        log.info("目标方法的执行结果：{}", result);

        log.info("MyAspect8 around after");
        return result;
    }
}
