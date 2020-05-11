package com.apress.springrecipes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;

// @SpringBootApplication
// @ComponentScan(
//         includeFilters = {
//                 @ComponentScan.Filter(
//                         type = FilterType.REGEX,
//                         pattern = {
//                                 "com.apress.springrecipes.cour.*",
//                         }
//                 )
//         }
//         , excludeFilters = {
//                 @ComponentScan.Filter(
//                         type = FilterType.ANNOTATION,
//                         classes = {
//                                 org.springframework.stereotype.Controller.class
//                         }
//                 )
//         }
// )

@SpringBootApplication
public class SpringrecipesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringrecipesApplication.class, args);
    }

}
