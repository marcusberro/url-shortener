package com.mberro.urlshortener.infrastructure;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;

/**
 * Created by Marcus Berro on 31/10/15.
 */
@Converter(autoApply = true)
public class JpaLocalDateTimeConverter implements AttributeConverter<LocalDateTime, Timestamp> {
    @Override
    public Timestamp convertToDatabaseColumn(LocalDateTime localDateTime) {
        return localDateTime != null? Timestamp.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant()):null;
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Timestamp timestamp) {
        return timestamp != null? timestamp.toLocalDateTime():null;
    }
}
