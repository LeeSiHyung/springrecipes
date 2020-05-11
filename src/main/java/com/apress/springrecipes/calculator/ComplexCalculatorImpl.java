package com.apress.springrecipes.calculator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component("complexCalculator")
public class ComplexCalculatorImpl implements ComplexCalculaotor {

    @Override
    public Complex add(Complex a, Complex b) {
        Complex result = new Complex(
                a.getReal() +  b.getReal(), a.getImaginary() + b.getImaginary());
        log.info(a + " + " + b + " = " + result);
        return result;
    }

    @Override
    public Complex sub(Complex a, Complex b) {
        Complex result = new Complex(
                a.getReal() -  b.getReal(), a.getImaginary() - b.getImaginary());
        log.info(a + " - " + b + " = " + result);
        return result;
    }
}
