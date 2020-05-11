package com.apress.springrecipes.shop;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.*;
import java.util.Date;
import java.util.Locale;

// @Component
@Setter
@Getter
@Slf4j
// public class Cashier implements BeanNameAware, ApplicationEventPublisherAware {
public class Cashier implements BeanNameAware { // , ApplicationEventPublisherAware {

    @Autowired
    private MessageSource messageSource;

    @Value("checkout")
    private String fileName;

    @Value("/tmpdir/cashier")
    private String path;

    private BufferedWriter writer;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @PostConstruct
    public void openFile() throws IOException {
        File targetDir = new File(path);
        if(!targetDir.exists()){
            targetDir.mkdirs();
        }

        File checkoutFile = new File(path, fileName + ".txt");
        if (!checkoutFile.exists()){
            checkoutFile.createNewFile();
        }

        writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(checkoutFile, true)));
    }

    public void checkout(ShoppingCart cart) throws IOException {
        String alert = messageSource.getMessage("alert.inventory.checkout", new Object[]{cart.getItems(), new Date()}, Locale.US);
        log.debug(alert);

        writer.write(new Date() + "\t" + cart.getItems() + "\r\n");
        writer.flush();

        CheckoutEvent event = new CheckoutEvent(cart, new Date());
        applicationEventPublisher.publishEvent(event);
    }

    @PreDestroy
    public void closeFile() throws IOException {
        writer.close();
    }


    @Override
    public void setBeanName(String name) {
        this.fileName = name;
    }

    // @Override
    // public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
    //     this.applicationEventPublisher = applicationEventPublisher;
    // }
}
