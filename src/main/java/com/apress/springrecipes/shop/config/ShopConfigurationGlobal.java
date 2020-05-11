package com.apress.springrecipes.shop.config;

import com.apress.springrecipes.shop.Cashier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

// @Configuration
// @Profile("global")
// @ComponentScan("com.apress.springrecipes.shop")
public class ShopConfigurationGlobal {

    @Bean(initMethod = "openFile", destroyMethod = "closeFile")
    public Cashier cashier(){
        final String path = System.getProperty("/tmpdir/cashier");
        Cashier c1 = new Cashier();
        c1.setFileName("checkout");
        // c1.setPath(path);
        return c1;
    }

    @Bean
    // 빈인스턴스는 반드시 messageSource로 명명해야 애플리케이션 컨텍스가 알아서 감지함.
    public ReloadableResourceBundleMessageSource messageSource(){
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames("classpath:messages");
        messageSource.setCacheSeconds(1);
        return messageSource;
    }

}
