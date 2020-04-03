package com.apress.springrecipes.shop.config;

import com.apress.springrecipes.BannerLoader;
import com.apress.springrecipes.shop.Battery;
import com.apress.springrecipes.shop.Cashier;
import com.apress.springrecipes.shop.Disc;
import com.apress.springrecipes.shop.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.io.Resource;

@Configuration
@PropertySource("classpath:discounts.properties")
@ComponentScan("com.apress.springrecipes.shop")
public class ShopConfiguration {

    @Value("${endofyear.discount:0}")
    private double specialEndofyearDiscountField;

    @Value("classpath:banner.txt")
    private Resource banner;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public Product aaa(){
        Battery p1 = new Battery("AAA", 2.5, true);
        p1.setRechargeable(true);
        return p1;
    }

    @Bean
    public Product cdrw(){
        Disc p2 = new Disc("CD-RW", 1.5);
        p2.setCapacity(700);
        return p2;
    }

    @Bean
    public Product dvdrw(){
        Disc p2 = new Disc("DVD-RW", 3.0);
        p2.setCapacity(700);
        return p2;
    }

    @Bean
    public BannerLoader bannerLoader(){
        BannerLoader bl = new BannerLoader();
        bl.setBanner(banner);
        return bl;
    }

    @Bean
    // 빈인스턴스는 반드시 messageSource로 명명해야 애플리케이션 컨텍스가 알아서 감지함.
    public ReloadableResourceBundleMessageSource messageSource(){
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames("classpath:messages");
        messageSource.setCacheSeconds(1);
        return messageSource;
    }

    // @Bean(initMethod = "openFile", destroyMethod = "closeFile")
    // public Cashier cashier(){
    //     // String path = System.getProperty("java.io.tmpdir") + "/cashier";
    //     String path = "/Users/we/Downloads/springrecipes/src/main/resources/tmpdir/cashier";
    //     Cashier c1 = new Cashier();
    //     c1.setFileName("checkout");
    //     c1.setPath(path);
    //     return c1;
    // }

    @Bean
    public Cashier cashier(){
        Cashier c1 = new Cashier();
        return c1;
    }

}
