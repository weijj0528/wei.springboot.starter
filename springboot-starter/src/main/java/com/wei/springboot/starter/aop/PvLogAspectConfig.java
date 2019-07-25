package com.wei.springboot.starter.aop;

import com.alibaba.fastjson.JSON;
import com.wei.springboot.starter.bean.ResultBean;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.BindingResult;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @createTime 2019/7/20 22:40
 * @description Pv日志打印，请求参数与响应
 */
@Slf4j
@Aspect
@Configuration
public class PvLogAspectConfig {

    @Around("execution(public com.wei.springboot.starter.bean.ResultBean *..*(..)) && (" +
            "@within(org.springframework.stereotype.Controller) ||" +
            "@within(org.springframework.web.bind.annotation.RestController))")
    public ResultBean around(ProceedingJoinPoint joinPoint) throws Throwable {
        // 请求参数
        String params = null;
        Object[] args = joinPoint.getArgs();
        if (args.length == 0) {
            params = "no params!";
        } else if (args.length == 1) {
            params = JSON.toJSONString(args[0]);
        } else {
            Map<String, Object> paramsMap = new HashMap<>();
            MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
            Parameter[] parameters = methodSignature.getMethod().getParameters();
            for (int i = 0; i < parameters.length; i++) {
                if (!(args[i] instanceof ServletRequest) &&
                        !(args[i] instanceof ServletResponse) &&
                        !(args[i] instanceof BindingResult)) {
                    paramsMap.put(parameters[i].getName(), args[i]);
                }
            }
            params = JSON.toJSONString(paramsMap);
        }
        log.info("[RQ] {}", params);
        ResultBean resultBean = (ResultBean) joinPoint.proceed();
        // 响应
        log.info("[RP] {}", JSON.toJSONString(resultBean));
        return resultBean;
    }

}