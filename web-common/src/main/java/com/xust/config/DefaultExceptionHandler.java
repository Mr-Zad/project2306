package com.xust.config;

import com.xust.VO.ResultJson;
import com.xust.core.PowernodeException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class DefaultExceptionHandler {

    @ExceptionHandler
    public ResultJson handle(Exception e){
//        System.out.println("进入统一异常处理。。。");
        e.printStackTrace();
        if(e instanceof PowernodeException){
            return ResultJson.failed(e.getMessage());
        }
        return ResultJson.failed("系统出错，请联系管理员");
    }
}
