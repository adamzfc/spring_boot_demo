package com.adamzfc.interfaces.mvc.advice;

import com.adamzfc.domain.model.Result;
import com.adamzfc.infrastructure.CommonUtils;
import com.adamzfc.infrastructure.exceptions.AppException;
import com.adamzfc.infrastructure.exceptions.Error;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.adamzfc.infrastructure.CommonUtils.getStackTrace;

/**
 * Created by adamzfc on 2017/7/10.
 */
@Slf4j
@ControllerAdvice("com.adamzfc.interfaces.api")
@ResponseBody
public class ApiControllerAdvice {

    @ExceptionHandler(Exception.class)
    public Result exception(Exception ex, HttpServletResponse response) {
        response.setStatus(500);
        log.error(ex.getMessage(), ex);
        return appExceptionToResult(new AppException(Error.UNKNOWN_EXCEPTION, getStackTrace(ex)));
    }

    private Result appExceptionToResult(AppException ex) {
        Result result = new Result();
        result.setSuccess(false);
        result.setCode(ex.getCode());
        result.setMsg(ex.getMessage());
        result.setDevMsg(ex.getDevMsg());
        return result;
    }

}
