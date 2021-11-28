package com.example.jwt3.config;


import com.example.jwt3.entity.RespBean;
import com.example.jwt3.exception.BusinessException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public RespBean exceptionHandler(Exception e) {
        e.printStackTrace();
        return RespBean.error("系统出错");
    }

    @ExceptionHandler(BusinessException.class)
    public RespBean BusinessExceptionHandler(BusinessException e) {
        if(null == e.getLocalizedMessage()) {
            return RespBean.error("操作异常");
        }
        return RespBean.error(e.getMsg());
    }
}
