package com.apress.springrecipes.spring3.executors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.SyncTaskExecutor;
import org.springframework.core.task.support.TaskExecutorAdapter;
import org.springframework.scheduling.concurrent.ScheduledExecutorFactoryBean;
import org.springframework.scheduling.concurrent.ScheduledExecutorTask;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executors;

// @Configuration
// @ComponentScan
public class ExecutorsConfiguration {

    @Bean
    public TaskExecutorAdapter taskExecutorAdapter(){
        // 단순 래퍼
        return new TaskExecutorAdapter(Executors.newCachedThreadPool());
    }

    @Bean
    public SimpleAsyncTaskExecutor simpleAsyncTaskExecutor(){
        // 전송한 잡마다 새로 Thread를 만들어 제공하며, 스래드를 풀링하거나 재사용하지 않는다.
        return new SimpleAsyncTaskExecutor();
    }

    @Bean
    public SyncTaskExecutor syncTaskExecutor(){
        // 동기적으로 잡을 실행 join으로 바로 연결, 사실상 스레딩은 완전히 건너뜀 run 메소드를 수동실행한 것과 다를 바 없음.
        return new SyncTaskExecutor();
    }

    @Bean
    public ScheduledExecutorFactoryBean scheduledExecutorFactoryBean(ScheduledExecutorTask scheduledExecutorTask){
        // ScheduledExecutorTask 빈으로 정의된 잡을 자동 트리거함. 여러 잡을 동시에 실행할 수 있음.
        ScheduledExecutorFactoryBean scheduledExecutorFactoryBean = new ScheduledExecutorFactoryBean();
        scheduledExecutorFactoryBean.setScheduledExecutorTasks(scheduledExecutorTask);
        return scheduledExecutorFactoryBean;
    }

    @Bean
    public ScheduledExecutorTask scheduledExecutorTask(Runnable runnable){
        // 작업 실행간 공백 시간을 인수로 넣는다.
        ScheduledExecutorTask scheduledExecutorTask = new ScheduledExecutorTask();
        scheduledExecutorTask.setPeriod(1000);
        scheduledExecutorTask.setRunnable(runnable);
        return scheduledExecutorTask;
    }

    @Bean
    public ThreadPoolTaskExecutor threadPoolTaskExecutor(){
        // 모든 기능이 완비된 스레드 풀 구현체
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(50);
        taskExecutor.setMaxPoolSize(100);
        taskExecutor.setAllowCoreThreadTimeOut(true);
        taskExecutor.setWaitForTasksToCompleteOnShutdown(true);
        return taskExecutor;
    }

}
