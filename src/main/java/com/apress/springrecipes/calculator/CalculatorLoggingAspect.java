package com.apress.springrecipes.calculator;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

// @Aspect
// @Component
// @Order(1)
@Slf4j
public class CalculatorLoggingAspect /*implements Ordered */{

    // @Pointcut("execution(* *.*(..))")
    // private void loggingOperation(){};


    // @Before("execution(* ArithmeticCalculator.add(..))")
    @Before("CalculatorPointcuts.loggingOperation()")
    // 포인트 컷은 여러 조인포인트를 매치하기 위해 지정한 표현식
    // 포인트 컷으로 매치한 실행 지점을 조인포인트라고 한다.
    // 조인포인트에서 해야할 일을 지정하는 것이 어드바이스
    public void logBefore(JoinPoint joinPoint){
        // log.info("The method add() begins");
        log.info("The method " + joinPoint.getSignature().getName()
                + "() begins with " + Arrays.toString(joinPoint.getArgs()));
    }

    @After("CalculatorPointcuts.loggingOperation()")
    public void logAfter(JoinPoint joinPoint){
        log.info("The method " + joinPoint.getSignature().getName() + "() ends");
    }


    @AfterReturning(pointcut = "CalculatorPointcuts.loggingOperation()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result){
        log.info("The Method " + joinPoint.getSignature().getName() + "() ends with " + result);
    }

    @AfterThrowing("CalculatorPointcuts.loggingOperation()")
    public void logAfterThrowing(JoinPoint joinPoint){
        log.error("An exception has been thrown in {}()", joinPoint.getSignature().getName());
    }

    @AfterThrowing(pointcut = "CalculatorPointcuts.loggingOperation()", throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable e){
        log.error("An exception {} has been thrown in {}()", e, joinPoint.getSignature().getName());
    }

    @AfterThrowing(pointcut = "CalculatorPointcuts.loggingOperation()", throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, IllegalArgumentException e){
        log.error("Illegal argument {} in {}()", Arrays.toString(joinPoint.getArgs()), joinPoint.getSignature().getName());
    }

    @Around("CalculatorPointcuts.loggingOperation()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable{
        log.info("The method {}() begins with {}", joinPoint.getSignature().getName(),
        Arrays.toString(joinPoint.getArgs()));

        try{
            Object result = joinPoint.proceed();
            log.info("The mehtod{}() ends with ", joinPoint.getSignature().getName(), result);
            return result;

        }
        catch (IllegalArgumentException e){
            log.error("Illegal argument {} in {}()"
                    , Arrays.toString(joinPoint.getArgs()), joinPoint.getSignature().getName());
            throw e;
        }

    }

    // @Before("CalculatorPointcuts.loggingOperation()")
    // public void logJoinPoint(JoinPoint joinPoint){
    //     log.info("Join point kind : {}", joinPoint.getKind()); // method-execution
    //     log.info("Signature declaring type : {}", joinPoint.getSignature().getDeclaringTypeName());
    //     log.info("Signature name : {}", joinPoint.getSignature().getName());
    //     log.info("Arguments : {}", Arrays.toString(joinPoint.getArgs()));
    //     log.info("Target class : {}", joinPoint.getTarget().getClass().getName());
    //     log.info("This class : {}", joinPoint.getThis().getClass().getName());
    // }


    // @Before("execution(* *.*(..)) && target(target) && args(a,b)")
    @Before("CalculatorPointcuts.parameterPointcut(target, a, b)")
    public void logParameter(Object target, double a, double b){
        log.info("Target class : " + target.getClass().getName());
        log.info("Arguments : " + a + ", " + b);
    }

    // @Override
    // public int getOrder() {
    //     return 1;
    // }

}
