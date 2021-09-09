package com.zahory.studentmgsystem.config.aop;

import com.zahory.studentmgsystem.model.constant.HttpStatusCode;
import com.zahory.studentmgsystem.model.vo.response.ResultVO;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;

@Aspect
@Component
public class ResultFailedCodeAspect {
    @Pointcut("execution(public com.zahory.studentmgsystem.model.vo.response.ResultVO " +
            "com.zahory.studentmgsystem.controller..*.*(..))")
    public void controllerResult() {
    }

    @AfterReturning(value = "controllerResult()", returning = "result")
    public Object afterReturning(ResultVO result) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (requestAttributes == null) {
            return result;
        }
        HttpServletResponse response = requestAttributes.getResponse();
        if (response == null) {
            return result;
        }

        if (result.getCode() == ResultVO.FAIL) {
            response.setStatus(HttpStatusCode.NOT_ACCEPTABLE);
        }

        return result;
    }
}
