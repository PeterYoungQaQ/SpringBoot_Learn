package net.peter.ssm.exception;
/*
 * @Author: Haoran
 * @Date: 2021/3/10 10:38
 * @Description: 自定义异常处理器
 */

import net.peter.ssm.utils.JsonData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class CustomExceptionHandler {

    private final static Logger logger  = LoggerFactory.getLogger(CustomExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    private JsonData handler(Exception e){

        logger.error("[ 系统异常 ]" + e.getMessage());

        if (e instanceof CustomException){
            CustomException customException = (CustomException) e;
            return JsonData.buildError(customException.getCode(), customException.getMsg());
        }else {
            return JsonData.buildError("全局异常，未知错误");
        }

    }
}
