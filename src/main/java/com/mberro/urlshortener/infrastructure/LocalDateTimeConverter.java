package com.mberro.urlshortener.infrastructure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Marcus Berro on 02/11/15.
 */
public class LocalDateTimeConverter implements Converter<String, LocalDateTime> {

    private static final Logger LOGGER = LoggerFactory.getLogger(LocalDateTimeConverter.class);

    private final String dateFormat;
    private final DateTimeFormatter formatter;

    public LocalDateTimeConverter(String dateFormat) {
        this.dateFormat = dateFormat;
        this.formatter = DateTimeFormatter.ofPattern(dateFormat);
    }

    @Override
    public LocalDateTime convert(String source) {
        LOGGER.trace("Converting the string: {} into a LocalDateTime object by using date format: {}.",
                source,
                dateFormat
        );

        if (source == null || source.isEmpty()) {
            LOGGER.trace("The source string is null. Returning null.");
            return null;
        }

        LocalDateTime dateAndTime = LocalDateTime.parse(source, formatter);
        LOGGER.trace("Converted the string: {} into a LocalDateTime: {}",
                source,
                dateAndTime
        );

        return dateAndTime;
    }
}
