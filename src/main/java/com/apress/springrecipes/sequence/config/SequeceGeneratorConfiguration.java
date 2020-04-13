package com.apress.springrecipes.sequence.config;

import com.apress.springrecipes.prefix.config.PrefixConfiguration;
import com.apress.springrecipes.prefix.PrefixGenerator;
import com.apress.springrecipes.sequence.SequenceGenerator;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

// @Configuration // 구성클래스임을 스프링에 알림.
// @Import(PrefixConfiguration.class)
// @ComponentScan("com.apress.springrecipes.sequence")
public class SequeceGeneratorConfiguration {

    // 다른 구성 클래스의 빈을 현재 구성 클래스의 스코프로 가져오기
    // @Value("#{datePrefixGenerator}")
    private PrefixGenerator prefixGenerator;

    private String suffix;

    // @Bean // 빈인스턴스 정의부
    // @DependsOn("datePrefixGenerator") // 빈을 초기화 하는 순서를 보장한다. datePrefixGenerator 빈이 먼저 생성한다.
    // @DependsOn({"datePrefixGenerator"}) // 리스트 형태도 가능하다.
    // @Required // 스프링이 감지해서 값의 존재 여부를 조사하고 프로퍼티 값이 없으면 BeanInitializationException 예외를 던짐
    public SequenceGenerator sequenceGenerator(){
        SequenceGenerator seqgen = new SequenceGenerator();
        seqgen.setPrefix("30");
        seqgen.setSuffix("A");
        seqgen.setInitial(100000);
        return seqgen;
    }


    // @Required
    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public void getApplicationCotext(){
        // 여러 곳에 분산된 POJO 참조 문제 해결하기
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                PrefixConfiguration.class, SequeceGeneratorConfiguration.class);
    }
}
