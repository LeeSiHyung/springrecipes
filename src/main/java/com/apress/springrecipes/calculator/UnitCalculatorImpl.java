package com.apress.springrecipes.calculator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@LoggingRequired
@Component("unitCalculator")
public class UnitCalculatorImpl implements UnitCalculator {
    @Override
    public double kilogramToPound(double kilogram) {
        double pound = kilogram * 2.2;
        log.info(kilogram + " kilogram = " + pound + " pound");
        return pound;
    }

    @Override
    public double kilogramToMile(double kilometer) {
        double mile = kilometer * 2.2;
        log.info(kilometer + " kilometer = " + mile + " mile");
        return mile;
    }
}
