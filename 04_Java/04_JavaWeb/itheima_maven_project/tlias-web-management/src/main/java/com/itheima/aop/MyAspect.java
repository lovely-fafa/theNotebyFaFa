package com.itheima.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Component
//@Aspect
public class MyAspect {

    // 抽取切入点表达式
    // @Pointcut("execution(* com.itheima.service.impl.DeptServiceImpl.*(..))")
    @Pointcut("@annotation(com.itheima.aop.MyLog)")
    private void pt(){}

    @Before("pt()")
    public void before() {
        log.info("before ...");
    }

    @Around("pt()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("around before ...");

        // 调用目标对象的原始方法执行
        Object result = proceedingJoinPoint.proceed();

        log.info("around after ...");
        return result;
    }

    @After("execution(* com.itheima.service.impl.DeptServiceImpl.*(..))")
    public void after() {
        log.info("around ...");
    }

    @AfterReturning("execution(* com.itheima.service.impl.DeptServiceImpl.*(..))")
    public void afterReturning() {
        log.info("afterReturning ...");
    }

    @AfterThrowing("execution(* com.itheima.service.impl.DeptServiceImpl.*(..))")
    public void afterThrowing() {
        log.info("afterThrowing ...");
    }
}
