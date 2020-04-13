package com.apress.springrecipes.shop.config;

import com.apress.springrecipes.shop.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;


 // ShopConfiguration component scan 범위
@Component
@Slf4j
public class ProductCheckBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        // ShopConfiguration에 생성된 빈 인스턴스 중 Product 타에만 로그를 남김
        if(bean instanceof Product){
            String productName = ((Product) bean).getName();
            log.info("In ProductCheckBeanPostProcessor.postProcessBeforeInitialization, Processing Product: " + productName);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        // ShopConfiguration에 생성된 빈 인스턴스 중 Product 타에만 로그를 남김
        if(bean instanceof Product){
            String productName = ((Product) bean).getName();
            log.info("In ProdcutCheckBeanPostProcessor.postProcessAfterInitalization, Processing Product: " + productName);
        }
        return bean;
    }
}
