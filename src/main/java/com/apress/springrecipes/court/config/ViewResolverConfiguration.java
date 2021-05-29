package com.apress.springrecipes.court.config;

import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;

import java.util.HashMap;
import java.util.Map;

public class ViewResolverConfiguration implements WebMvcConfigurer {

    @Override
    // ContentNegotiationManager는 configureContentNegotiation 메서드를 오버라이드 할 때 기본 추가 됩니다.
    // 내부적으로 ContentNegotiationConfigurer의 ContentNegotiationManagerFactoryBean 팩토리 빈이 ContentNegotiationManager 객체를 생성
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        Map<String, MediaType> mediaTypes = new HashMap<>();
        mediaTypes.put("html", MediaType.TEXT_HTML);
        mediaTypes.put("pdf", MediaType.valueOf("application/pdf"));
        mediaTypes.put("xls", MediaType.valueOf("application/vnd.ms-excel"));
        mediaTypes.put("xml", MediaType.APPLICATION_XML);
        mediaTypes.put("json", MediaType.APPLICATION_JSON);
        configurer.mediaTypes(mediaTypes);
    }

    @Bean
    // 콘텐트 협상 기능을 제대로 작동하려면 contentNegotiatingViewResolver의 우선순위를 가장 높게 설정해야 합니다.
    // 이 리졸버는 스스로 뷰를 해석하지 않고 다른 리졸버에게 그 작업을 넘기기 때문.
    public ContentNegotiatingViewResolver contentNegotiatingViewResolver(
            ContentNegotiationManager contentNegotiationManager){

        ContentNegotiatingViewResolver viewResolver = new ContentNegotiatingViewResolver();
        viewResolver.setContentNegotiationManager(contentNegotiationManager);
        return viewResolver;
    }
}
