package com.bailis.gathering.controller;

import entity.Result;
import entity.StatusCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhulang
 * @Classname BaseExceptionHandler 统一异常处理类
 * @Description TODO
 * @Date 2020/7/5 15:26
 */
@ControllerAdvice
public class GatheringExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result error(Exception e) { e.printStackTrace();
        return new Result(false, StatusCode.ERROR, e.getMessage());
    }
}
