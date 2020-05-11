package com.apress.springrecipes.calculator;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// @Aspect
@Slf4j
public class ComplexCachingAspect {

    private final Map<String, Complex> cache = new ConcurrentHashMap<>();

    public void setCache(Map<String, Complex> cache){
        this.cache.clear();
        this.cache.putAll(cache);
    }

    @Around("call(public Complex.new(int, int)) && args(a, b)")
    public Object cacheAround(ProceedingJoinPoint joinPoint, int a, int b) throws Throwable{
        String key = a + "," + b;
        Complex complex = cache.get(key);
        if(complex == null){
            log.info("Cache MISS for (" + key + ")");
            complex = (Complex) joinPoint.proceed();
            cache.put(key, complex);
        }
        else{
            log.info("Cache HIT for (" + key + ")");
        }

        return complex;
    }
}
