package com.apress.springrecipes.calculator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Configurable
@Component
@Scope("prototype")
@NoArgsConstructor
@Getter
@Setter
public class Complex2 {

    private int real;
    private int imaginary;

    public Complex2(int real, int imaginary){
        this.real = real;
        this.imaginary = imaginary;
    }

    private ComplexFormatter formatter;

    @Autowired
    public void setFormatter(ComplexFormatter formatter){
        this.formatter = formatter;
    }


    public String toString(){
        return formatter.format(this);
    }

}
