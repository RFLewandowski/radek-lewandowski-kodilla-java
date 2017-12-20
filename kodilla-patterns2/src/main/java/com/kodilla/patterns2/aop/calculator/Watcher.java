package com.kodilla.patterns2.aop.calculator;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Slf4j
@Aspect
@Component
public class Watcher {

    @Before("execution(* com.kodilla.patterns2.aop.calculator.Calculator.factorial(..))" +
            "&& args(theNumber) &&target(object)")
    public void logEvent(BigDecimal theNumber, Object object) {
        log.info("Logging the event: Class: " + object.getClass().getName() + ", Args: " + theNumber);
    }

    @Around("execution(* com.kodilla.patterns2.aop.calculator.Calculator.factorial(..))")
    public Object mesureTime(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result = null;
        try {
            long begin = System.currentTimeMillis();
            result = proceedingJoinPoint.proceed();
            long end = System.currentTimeMillis();
            log.info("Time consumed: " + (end - begin) + "[ms]");
        } catch (Throwable throwable) {
            log.error(throwable.getMessage());
            throwable.printStackTrace();
        }
        return result;
    }
}
