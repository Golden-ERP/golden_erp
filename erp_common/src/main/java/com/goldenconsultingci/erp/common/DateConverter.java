package com.goldenconsultingci.erp.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.function.Function;

public class DateConverter {
    private static final String DATE_FORMAT = "dd-MM-yyyy";
    private static final String DATETIME_FORMAT = "dd-MM-yyyy HH:mm";
    private static final DateTimeFormatter DATE_FORMATTER =
            DateTimeFormatter.ofPattern(DATE_FORMAT).withZone(ZoneId.of("Africa/Abidjan"));
    private static final DateTimeFormatter DATETIME_FORMATTER =
            DateTimeFormatter.ofPattern(DATETIME_FORMAT).withZone(ZoneOffset.UTC);

    private DateConverter() {}
    public static LocalDate currentDate() {
        return LocalDate.now(ZoneId.of("Africa/Abidjan"));
    }

    public static LocalDateTime currentDatetime() {
        return LocalDateTime.now(ZoneId.of("Africa/Abidjan"));
    }


    public static String toString(LocalDate localDate) {
        if (localDate != null) {
            return localDate.format(DATE_FORMATTER);
        }

        return null;
    }

    public static String toString(LocalDateTime localDateTime) {
        if (localDateTime != null) {
            return localDateTime.format(DATETIME_FORMATTER);
        }
        return null;
    }

    public static LocalDateTime toDateTime(String dateTime) {
        if (dateTime != null) {
            return LocalDateTime.parse(dateTime, DATETIME_FORMATTER);
        }
        return null;
    }

    public static LocalDate toDate(String date) {
        if (date != null) {
            return LocalDate.parse(date, DATE_FORMATTER);
        }
        return null;
    }
}
