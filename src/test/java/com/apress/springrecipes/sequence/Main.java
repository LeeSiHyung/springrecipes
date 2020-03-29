package com.apress.springrecipes.sequence;

import com.apress.springrecipes.sequence.config.SequeceGeneratorConfiguration;
import com.apress.springrecipes.sequence.SequenceGenerator;
import com.apress.springrecipes.sequence.dao.SequneceDao;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class Main {

    @Test
    public void test1(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SequeceGeneratorConfiguration.class);

        // ioc 컨테이너에서 POJO 인스턴스 / 빈 가져오기
        // SequenceGenerator generator = (SequenceGenerator) context.getBean("sequenceGenerator");
        // SequenceGenerator generator = context.getBean("sequenceGenerator", SequenceGenerator.class);
        // 빈이 하나 뿐이라면 빈의 이름을 제거할 수 있음
        SequenceGenerator generator = context.getBean( SequenceGenerator.class);
        log.info(generator.getSequence());
        log.info(generator.getSequence());
    }

    @Test
    public void test2(){
        ApplicationContext context = new AnnotationConfigApplicationContext("com.apress.springrecipes.sequence");
        SequneceDao sequneceDao = context.getBean(SequneceDao.class);

        log.info("" + sequneceDao.getNextValue("IT"));
        log.info("" + sequneceDao.getNextValue("IT"));
    }
}
