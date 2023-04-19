package com.itheima.exception;


import com.itheima.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 */
@RestControllerAdvice
public class GlobalExceptionHandle {

    @ExceptionHandler(Exception.class)  // 所有的异常
    public Result ex(Exception ex) {
        ex.printStackTrace();
        return Result.error("操作异常，请联系管理员...");
    }

}
