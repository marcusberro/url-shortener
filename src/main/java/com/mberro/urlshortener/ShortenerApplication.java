package com.mberro.urlshortener;

import com.mberro.urlshortener.infrastructure.LocalDateTimeConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.PostConstruct;

/**
 * Created by Marcus Berro on 24/10/15.
 */
@SpringBootApplication
public class ShortenerApplication extends WebMvcConfigurerAdapter{

    private static final Logger logger = LoggerFactory.getLogger(ShortenerApplication.class);
    private final String ISO_DATE_FORMAT = "yyyy-MM-dd";
    private final String ISO_DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS";

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new LocalDateTimeConverter(ISO_DATE_TIME_FORMAT));
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ShortenerApplication.class, args);
    }

    @PostConstruct
    public void logSomething() {
        logger.debug("Sample Debug Message");
        logger.trace("Sample Trace Message");
    }
}
