package com.apress.springrecipes.calculator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MinCalculatorImpl implements MinCalculator {
    @Override
    public double min(double a, double b) {
        double result = (a <= b) ? a : b;
        log.info("min(" + a + ", " + b + ") = " + result);
        return result;
    }
}
