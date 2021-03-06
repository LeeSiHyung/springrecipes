package com.apress.springrecipes.calculator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@LoggingRequired
@Component("arithmeticCalculator")
public class ArithmeticCalculatorImpl implements ArithmeticCalculator{
    @Override
    public double add(double a, double b) {
        double result = a+b;
        log.info(a + " + " + b + " = " + result);
        return result;
    }

    @Override
    public double sub(double a, double b) {
        double result = a-b;
        log.info(a + " - " + b + " = " + result);
        return result;
    }

    @Override
    public double mul(double a, double b) {
        double result = a*b;
        log.info(a + " * " + b + " = " + result);
        return result;
    }

    @Override
    public double div(double a, double b) {
        if (b == 0){
            throw new IllegalArgumentException("Division by zero");
        }
        double result = a/b;
        log.info(a + " / " + b + " = " + result);
        return result;
    }
}
