package com.apress.springrecipes;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

@Setter
@Slf4j
public class BannerLoader {

    private Resource banner;

    @PostConstruct
    public void showBanner() throws IOException {
        Files.lines(Paths.get(banner.getURI()), Charset.forName("UTF-8"))
                .forEachOrdered(log::info);
    }


}
