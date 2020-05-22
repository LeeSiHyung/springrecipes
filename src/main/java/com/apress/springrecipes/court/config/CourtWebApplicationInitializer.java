package com.apress.springrecipes.court.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class CourtWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{CourtConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    // applicationContext 먼저 생성되고, dispatcherServlet은 applicationContext를 부모로 가지고 있는다.

    /**
     <context-param>
        <param-name>contextConfigLocation</param-name>
        <param-value> classpath:spring/application-context.xml </param-value>
     </context-param>

     ContextLoaderListener는 applicationContext를 생성

     <listener>
        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
     </listener>

     <servlet>
        <servlet-name>dispatcherServlet</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <init-param> <param-name>contextConfigLocation</param-name>
            <param-value>classpath:spring/spring-servlet.xml</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
     </servlet>

    **/
}
