package com.apress.springrecipes.calculator;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.Aspects;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@SpringBootTest(classes = {
        CalculatorConfiguration.class,
        ComplexFormatter.class,
})
public class Main2 {

    @Autowired
    Complex2 complex;

    @Test
    public void 복소수_테스트() {
        // -ea -javaagent:C:\Users\dltlg\.gradle\caches\modules-2\files-2.1\org.aspectj\aspectjweaver\1.9.5\1740dc9140103b796d1722668805fd4cf852780c\aspectjweaver-1.9.5.jar
        log.info(complex.toString());
    }
}
