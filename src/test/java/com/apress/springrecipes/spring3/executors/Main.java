package com.apress.springrecipes.spring3.executors;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Main {

    @Test
    public void test() throws ExecutionException, InterruptedException {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(1000 * 60);
                    log.info("Done sleeping for a minute, returning! ");
                }
                catch (Exception ex){}
            }
        };

        ExecutorService executorService = Executors.newCachedThreadPool();
        if (executorService.submit(task, Boolean.TRUE).get().equals(Boolean.TRUE)){
            log.info("job has finished!");
        }
    }


}
