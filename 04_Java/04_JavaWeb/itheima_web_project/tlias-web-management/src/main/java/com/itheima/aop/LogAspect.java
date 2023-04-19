package com.itheima.aop;

import com.alibaba.fastjson.JSONObject;
import com.itheima.mapper.OperateLogMapper;
import com.itheima.pojo.OperateLog;
import com.itheima.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class LogAspect {

    // 自动交给 IOC 容器管理 所以可以自动注入
    @Autowired
    private HttpServletRequest httpServletRequest;

    @Autowired
    private OperateLogMapper operateLogMapper;

    @Around("@annotation(com.itheima.anno.Log)")
    public Object recordLog(ProceedingJoinPoint joinPoint) throws Throwable {

        // 操作人
        String jwc = httpServletRequest.getHeader("token");
        Claims claims = JwtUtils.parseJWT(jwc);
        Integer operateUser = (Integer) claims.get("id");

        // 操作时间
        LocalDateTime now = LocalDateTime.now();

        // 操作类名
        String className = joinPoint.getTarget().getClass().getName();

        // 操作方法名
        String methodName = joinPoint.getSignature().getName();

        // 操作方法参数
        Object[] args = joinPoint.getArgs();
        String argsName = Arrays.toString(args);

        // 方法返回值
        long begin = System.currentTimeMillis();
        // 调用原始目标方法
        Object result = joinPoint.proceed();
        String resultStr = JSONObject.toJSONString(result);

        // 耗时
        long end = System.currentTimeMillis();
        long costTime = end - begin;

        // 纪录日志
        OperateLog operateLog = new OperateLog(null, operateUser, now, className, methodName, argsName, resultStr, costTime);
        operateLogMapper.insert(operateLog);
        log.info("AOP 记录日志：{}", operateLog);

        return result;
    }
}
