package com.haopyh.ssmp.controller;

import com.haopyh.ssmp.controller.utils.R;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice
@ControllerAdvice
public class ProjectExceptionAdvice {

    @ExceptionHandler
    R doException(Exception e){
        e.printStackTrace();
        return new R("异常");
    }
}
