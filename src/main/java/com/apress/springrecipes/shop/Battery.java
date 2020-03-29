package com.apress.springrecipes.shop;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Battery extends Product{
    private boolean rechargeable;

    public Battery() {
        super();
    }

    public Battery(String name, double price) {
        super(name, price);
    }

    public Battery(String name, double price, boolean rechargeable) {
        super(name, price);
        this.rechargeable = rechargeable;
    }

}
