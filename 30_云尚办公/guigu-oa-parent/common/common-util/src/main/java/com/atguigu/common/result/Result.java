package com.atguigu.common.result;

import lombok.Data;

@Data
public class Result<T> {

    private Integer code;
    private String message;
    private T data;

    private Result() {

    }

    // 封装返回的数据
    public static <T> Result<T> build(T data, ResultCodeEnum resultCodeEnum) {
        Result<T> result = new Result<>();
        // 封装数据
        if (data != null) {
            result.setData(data);
        }
        // 状态码
        result.setCode(resultCodeEnum.getCode());
        // 信息
        result.setMessage(resultCodeEnum.getMessage());
        return result;
    }


    // 成功
    public static <T> Result<T> success() {
        return Result.build(null, ResultCodeEnum.SUCCESS);
    }

    public static <T> Result<T> success(T data) {
        return Result.build(data, ResultCodeEnum.SUCCESS);
    }

    public static <T> Result<T> error() {
        return Result.build(null, ResultCodeEnum.ERROR);
    }

    public static <T> Result<T> error(T data) {
        return Result.build(data, ResultCodeEnum.ERROR);
    }

    public Result<T> message(String msg) {
        this.setMessage(msg);
        return this;
    }

    public Result<T> code(Integer code) {
        this.setCode(code);
        return this;
    }
}
