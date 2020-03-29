package com.apress.springrecipes.shop;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Disc extends Product {
    private int capacity;

    public Disc() {
        super();
    }

    public Disc(String name, double price) {
        super(name, price);
    }
}
