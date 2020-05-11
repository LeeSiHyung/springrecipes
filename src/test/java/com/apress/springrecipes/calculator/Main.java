package com.apress.springrecipes.calculator;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class Main {

    @Test
    public void test(){
        ApplicationContext context = new AnnotationConfigApplicationContext(CalculatorConfiguration.class);
        ArithmeticCalculator arithmeticCalculator
                = context.getBean("arithmeticCalculator", ArithmeticCalculator.class);
        arithmeticCalculator.add(1,2);
        arithmeticCalculator.sub(4,3);
        arithmeticCalculator.mul(2,3);
        arithmeticCalculator.div(4,2);

        UnitCalculator unitCalculator = context.getBean("unitCalculator", UnitCalculator.class);
        unitCalculator.kilogramToPound(10);
        unitCalculator.kilogramToMile(5);
    }

    @Test
    public void 인트로덕션_테스트(){
        ApplicationContext context = new AnnotationConfigApplicationContext(CalculatorConfiguration.class);
        ArithmeticCalculator arithmeticCalculator = context.getBean("arithmeticCalculator", ArithmeticCalculator.class);

        MaxCalculator maxCalculator = (MaxCalculator) arithmeticCalculator;
        maxCalculator.max(1, 2);

        MinCalculator minCalculator = (MinCalculator) arithmeticCalculator;
        minCalculator.min(1, 2);
    }

    @Test
    public void 인트로덕션_테스트2(){
        ApplicationContext context = new AnnotationConfigApplicationContext(CalculatorConfiguration.class);

        ArithmeticCalculator arithmeticCalculator = context.getBean("arithmeticCalculator", ArithmeticCalculator.class);
        arithmeticCalculator.add(1,2);
        arithmeticCalculator.sub(4,3);
        arithmeticCalculator.mul(2,3);
        arithmeticCalculator.div(4,2);


        UnitCalculator unitCalculator = context.getBean("unitCalculator", UnitCalculator.class);
        unitCalculator.kilogramToPound(10);
        unitCalculator.kilogramToMile(5);


        Counter arithmeticCounter = (Counter) arithmeticCalculator;
        log.info("arithmeticCounter : " + arithmeticCounter.getCount());

        Counter unitCounter = (Counter) unitCalculator;
        log.info("unitCounter : " + unitCounter.getCount());
    }

    @Test
    public void 복소수_테스트(){
        ApplicationContext context = new AnnotationConfigApplicationContext(CalculatorConfiguration.class);
        ComplexCalculaotor complexCalculaotor = context.getBean("complexCalculator", ComplexCalculaotor.class);
        complexCalculaotor.add(new Complex(1, 2), new Complex(2, 3));
        complexCalculaotor.sub(new Complex(5, 8), new Complex(2, 3));
    }

}
