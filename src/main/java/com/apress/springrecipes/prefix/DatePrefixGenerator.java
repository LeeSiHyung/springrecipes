package com.apress.springrecipes.prefix;


import com.apress.springrecipes.prefix.annotation.DatePrefixAnnotation;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

// @Component
// @Primary
// @DatePrefixAnnotation
public class DatePrefixGenerator implements PrefixGenerator {

    // @Inject
    private PrefixGenerator prefixGenerator;

    @Override
    public String getPrefix() {
        DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        return formatter.format(new Date());
    }

}
