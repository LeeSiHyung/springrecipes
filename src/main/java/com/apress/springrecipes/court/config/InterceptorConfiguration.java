package com.apress.springrecipes.court.config;

import com.apress.springrecipes.court.interceptor.MeasurementInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 여러 인터셉터 설정이 가능함, 특정 URL 매핑도 가능
        registry.addInterceptor(measurementInterceptor());
        // registry.addInterceptor(measurementInterceptor()).addPathPatterns("/reservationSummary*");
        // registry.addInterceptor(measurementInterceptor()).excludePathPatterns("/reservationSummary*");
    }

    @Bean
    public MeasurementInterceptor measurementInterceptor(){
        return new MeasurementInterceptor();
    }
}
