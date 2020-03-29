package com.apress.springrecipes.sequence;

import com.apress.springrecipes.prefix.PrefixGenerator;
import com.apress.springrecipes.prefix.annotation.DatePrefixAnnotation;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.inject.Inject;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
public class SequenceGenerator {

    // @Autowired(required = false)
    // @Qualifier("datePrefixGenerator") // 후보 빈 명시

    @Inject @DatePrefixAnnotation
    private PrefixGenerator prefixGenerator;

    private String prefix;
    private String suffix;
    private int initial;
    private final AtomicInteger counter = new AtomicInteger();

    public String getSequence(){
        StringBuilder builder = new StringBuilder();
        builder.append(prefix)
                .append(initial)
                .append(counter.getAndIncrement())
                .append(suffix);
                return builder.toString();
    }

    @Autowired(required = false)
    public void myOwnCustomInjectionName(@Qualifier("datePrefixGenerator") PrefixGenerator prefixGenerator){
        this.prefixGenerator = prefixGenerator;
    }

}
