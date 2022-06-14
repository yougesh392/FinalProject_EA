package com.miu.MainApplication.Advice;

import com.miu.MainApplication.Logging.ILogger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Aspect
@Configuration
public class LogAspect {
    @Autowired
    public ILogger logger;

    @After("execution(* com.miu.MainApplication.controller.*.*(..))")
    public void logAfter(JoinPoint joinpoint) {
        logger.log("$$$$$:" + joinpoint.getSignature().getName());
    }

}
