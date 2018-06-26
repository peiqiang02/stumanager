package cn.edu.zucc.stumanager.handle;

import cn.edu.zucc.stumanager.dto.Result;
import cn.edu.zucc.stumanager.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
//        return ResultUtil.error(100,e.getMessage());
        return ResultUtil.error(100, "系统繁忙");
    }
}
