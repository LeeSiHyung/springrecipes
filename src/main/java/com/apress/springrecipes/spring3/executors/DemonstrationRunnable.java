package com.apress.springrecipes.spring3.executors;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
// @Component
public class DemonstrationRunnable implements Runnable {

    @Override
    public void run() {
        try{
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info(Thread.currentThread().getName());
        System.out.printf("Hello at %s \n", new Date());
    }
}
