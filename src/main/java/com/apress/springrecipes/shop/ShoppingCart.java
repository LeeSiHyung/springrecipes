package com.apress.springrecipes.shop;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype") // getBean 메서드를 호출할 때 마다 빈 인스턴스를 새로 만듬
public class ShoppingCart {

    private List<Product> items = new ArrayList<>();

    public void addItem(Product item){
        items.add(item);
    }

    public List<Product> getItems(){
        return items;
    }
}
