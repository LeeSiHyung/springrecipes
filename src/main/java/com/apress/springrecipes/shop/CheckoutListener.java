package com.apress.springrecipes.shop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

// @Component
@Slf4j
public class CheckoutListener  /** implements ApplicationListener<CheckoutEvent> **/ {


    // 스프링 4.2 부터는 ApplicationLisener 인터페이스 없이 @EventListener를 붙여도 이벤트 리스너로 만들 수 있다.
    // @Override
    // public void onApplicationEvent(CheckoutEvent event) {
    //     // 체크아웃 시각으로 할 일을 여기에 구현
    //     log.info("Checkout event [" + event.getTime() + "]");
    // }

    @EventListener // 스프링 프레임워크에 종속되지 않기 위해서 어노테이션을 활용한 POJO로 구현될 수 있다.
    public void onApplicationEvent(CheckoutEvent event){
        // 체크아웃 시각으로 할 일을 여기에 구현
        log.info("Checkout event [" + event.getTime() + "]");
    }

}
