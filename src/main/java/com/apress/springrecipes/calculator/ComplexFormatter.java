package com.apress.springrecipes.calculator;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Setter
@Getter
public class ComplexFormatter {

    @Value("(a + b)")
    private String pattern;

    public String format(Complex2 complex2){
        return pattern
                .replaceAll("a", Integer.toString(complex2.getReal()))
                .replaceAll("b", Integer.toString(complex2.getImaginary()));
    }

}
