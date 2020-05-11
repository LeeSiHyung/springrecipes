package com.apress.springrecipes.shop;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

// @Component
// @Scope("prototype") // getBean 메서드를 호출할 때 마다 빈 인스턴스를 새로 만듬
// @Lazy // 애플리케이션이 요구하거나 다른 POJO가 참조하기 전까 초기화 하지 않는다.
public class ShoppingCart {

    private List<Product> items = new ArrayList<>();

    public void addItem(Product item){
        items.add(item);
    }

    public List<Product> getItems(){
        return items;
    }
}
