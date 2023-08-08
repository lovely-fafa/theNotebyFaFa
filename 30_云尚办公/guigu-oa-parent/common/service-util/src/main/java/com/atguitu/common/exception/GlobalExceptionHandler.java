package com.atguitu.common.exception;

import com.atguigu.common.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    @ResponseBody
    public Result<Object> globalError(Exception e) {
        log.error("未知错误 {}", e);
        return Result.error().message("未知错误" + e);
    }

    // 特定异常处理
    @ExceptionHandler(ArithmeticException.class)
    public Result<Object> error() {
        return Result.error().message("除零异常");
    }

//    @ExceptionHandler(AccessDeniedException.class)
//    @ResponseBody
//    public Result<Object> error (AccessDeniedException e) {
//        return Result.error().message("没有操作权限");
//    }
}
