package com.apress.springrecipes.spring3.executors;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;

import java.util.Date;
import java.util.concurrent.*;

@Slf4j
public class ExecutorsDemo {

    @Test
    public void test() throws ExecutionException, InterruptedException {
        Runnable task = new DemonstrationRunnable();

        ExecutorService cachedThreadPoolExecutorService = Executors.newCachedThreadPool();
        if (cachedThreadPoolExecutorService.submit(task).get() == null){
            System.out.printf("The cachedThreadPoolExecutorService has succeeded at %s \n", new Date());
        }

        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(100);
        if(fixedThreadPool.submit(task).get() == null){
            System.out.printf("fixedThreadPool has succeeded at %s \n", new Date());
        }

        ExecutorService singleThreadExecutorService = Executors.newSingleThreadExecutor();
        if (singleThreadExecutorService.submit(task).get() == null){
            System.out.printf("singleThreadExecutorService has succeded at %s \n",
                    new Date());
        }

        ExecutorService es = Executors.newCachedThreadPool();
        if(es.submit(task, Boolean.TRUE).get().equals(Boolean.TRUE)){
            System.out.printf("job has finished!");
        }

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
        if (scheduledExecutorService.schedule(task, 30, TimeUnit.SECONDS).get() == null){
            System.out.printf("scheduledThreadExecutorService has succeeded at %s \n", new Date());
        }

        scheduledExecutorService.scheduleAtFixedRate(task, 0, 5, TimeUnit.SECONDS);

    }

}
