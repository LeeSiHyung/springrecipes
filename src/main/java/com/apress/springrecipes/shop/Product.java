package com.apress.springrecipes.shop;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public abstract class Product {
    private String name;
    private double price;

}
