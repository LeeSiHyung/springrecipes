package com.apress.springrecipes.shop;

import com.apress.springrecipes.shop.config.ShopConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;

@Slf4j
public class Main {

    @Test
    public void test1(){
        ApplicationContext context = new AnnotationConfigApplicationContext(ShopConfiguration.class);

        Product aaa = context.getBean("aaa", Product.class);
        Product cdrw = context.getBean("cdrw", Product.class);
        Product dvdrw = context.getBean("dvdrw", Product.class);

        ShoppingCart cart1 = context.getBean("shoppingCart", ShoppingCart.class);
        cart1.addItem(aaa);
        cart1.addItem(cdrw);
        log.debug("Shopping cart 1 contains " + cart1.getItems());

        ShoppingCart cart2 = context.getBean("shoppingCart", ShoppingCart.class);
        cart2.addItem(dvdrw);
        log.debug("Shopping cart 2 contains " + cart2.getItems());

    }

    @Test
    public void test2() throws IOException {
        // Resource resource = new ClassPathResource("discounts.properties");
        Resource resource = new FileSystemResource("/Users/we/Downloads/springrecipes/src/main/resources/discounts.properties");
        Properties props = PropertiesLoaderUtils.loadProperties(resource);

        log.debug("And don't forget our discount!");
        log.debug(props.toString());
    }

    @Test
    public void test3() throws IOException {
        ApplicationContext context = new AnnotationConfigApplicationContext(ShopConfiguration.class);

        String alert = context.getMessage("alert.checkout", null, Locale.US);
        String alert_inventory = context.getMessage("alert.inventory.checkout", new Object[]{"DVD-RW 3.0", new Date()}, Locale.US);

        log.debug("The I18N message for alert.checkout is : " + alert);
        log.debug("The I18N message for alert.inventory.checkout is : " + alert_inventory);
    }

}
