package com.apress.springrecipes.court.web;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.Set;

// 웹 배포 서술자 (web.xml, ServletContainerInitializer)는 자바 웹 애플리케이션의 필수 구성 파일
public class CourtServletContainerInitializer implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {

    }
}
