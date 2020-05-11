package com.apress.springrecipes.calculator;

import org.aspectj.lang.Aspects;
import org.springframework.beans.factory.aspectj.AnnotationBeanConfigurerAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;

import java.util.HashMap;
import java.util.Map;

// @Configuration
// @EnableAspectJAutoProxy
// @ComponentScan // 컨피겨레이션에 컴포넌트 스캔을 설정한다.
// @EnableLoadTimeWeaving
// @EnableSpringConfigured
public class CalculatorConfiguration {

    @Bean
    public ComplexCachingAspect complexCachingAspect(){
        Map<String, Complex> cache = new HashMap<>();
        cache.put("2,3", new Complex(2,3));
        cache.put("3,5", new Complex(3,5));

        // Aspects.aspectOf를 사용하면 현재 애스펙트 인스턴스에 액세스 할 수 있다.
        ComplexCachingAspect complexCachingAspect =
                Aspects.aspectOf(ComplexCachingAspect.class);
        complexCachingAspect.setCache(cache);
        return complexCachingAspect;
    }

    @Bean
    public Complex2 complex(){
        return new Complex2(2,3);
    }

//    @Bean
//    public Complex2 complex1(){
//        return new Complex2(1,2);
//    }
//
//    @Bean
//    public Complex2 complex2(){
//        return new Complex2(2,3);
//    }

}
