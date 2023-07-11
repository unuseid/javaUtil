package com.miribit.util;

import com.google.api.client.util.DateTime;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Slf4j
public class DateUtil {
    public static final String YMD = "yyyy-MM-dd";
    public static final String YMD_HMS_RFC_3339 = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    public static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat(YMD);
    public static final SimpleDateFormat SIMPLE_DATETIME_FORMAT = new SimpleDateFormat(YMD_HMS_RFC_3339);
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(YMD);
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(YMD_HMS_RFC_3339);
    public static final ZoneId ZONE_ID = ZoneId.systemDefault();


    public static LocalDateTime getNow_LocalDateTimeUTC(){
        return ZonedDateTime.now(ZoneOffset.UTC).toLocalDateTime();
    }

    public static LocalDateTime getYesterday_LocalDateTimeUTC(){
        return ZonedDateTime.now(ZoneOffset.UTC).toLocalDateTime().minusDays(1);
    }

    public static LocalDate getNow_LocalDateUTC(){
        return ZonedDateTime.now(ZoneOffset.UTC).toLocalDate();
    }

    public static DateTime getNow_DateTime() {
        LocalDateTime now = LocalDateTime.now();
        return localDateTime2DateTime(now);
    }

    public static Date getNow_Date() {
        return localDate2date(LocalDate.now());
    }

    public static Date getToay_Date() {
        LocalDate localDate = LocalDate.now();
        Date date = localDate2date(localDate);
        return date;
    }

    public static LocalDate getToay_LocalDate() {
        return LocalDate.now();
    }

    public static Date getYesterDay_Date() {
        LocalDate localDate = LocalDate.now();
        localDate = localDate.minusDays(1);
        Date date = localDate2date(localDate);
        return date;
    }


    public static LocalDate getYesterDay_LocalDateUTC() {
        LocalDate localDate = getNow_LocalDateUTC();
        localDate = localDate.minusDays(1);
        return localDate;
    }

    public static Date minusDate(Date date, int minus) {
        LocalDate localDate2 = date2Localdate(date);
        LocalDate localDate3 = localDate2.minusDays(minus);
        Date date1 = localDate2date(localDate3);
        return date1;
    }

    public static Date plusDate(Date date, int plus) {
        LocalDate localDate2 = date2Localdate(date);
        LocalDate localDate3 = localDate2.plusDays(plus);
        Date date1 = localDate2date(localDate3);
        return date1;
    }

    /**
     * date가 크면 1 date2가 크면 -1 같으면 0
     *
     * @param date
     * @param date2
     * @return
     */
    public static int compareDate(Date date, Date date2) {
        return date.compareTo(date2);
    }

    public static int compareDate(Date date, LocalDate date2) {
        return date.compareTo(localDate2date(date2));
    }

    public static int compareDate(LocalDate date, LocalDate date2) {
        return date.compareTo(date2);
    }

    public static LocalDate date2Localdate(Date date) {
        return date.toInstant().atZone(ZONE_ID).toLocalDate();
    }

    public static Date localDate2date(LocalDate localDate) {
        try {
            String dateStr = localDate.format(DATE_FORMATTER);
            return SIMPLE_DATE_FORMAT.parse(dateStr);
        } catch (ParseException e) {
            log.error("", e);
        }
        return null;
    }

    public static DateTime localDateTime2DateTime(LocalDateTime dateTime) {
        return new DateTime(dateTime.format(DATE_TIME_FORMATTER));
    }

    public static DateTime strToDateTime(String str) {
        try{
            return localDateTime2DateTime(LocalDateTime.parse(str, DATE_TIME_FORMATTER));
        }catch (Exception e){
            log.error("",e);
            return null;
        }
    }
    public static LocalDateTime strToLocalDateTime(String str) {
        try{
            return LocalDateTime.parse(str, DATE_TIME_FORMATTER);
        }catch (Exception e){
            log.error("",e);
            return null;
        }
    }
    public static DateTime getDefaultDateTime() {
        LocalDateTime ldt = LocalDateTime.of(2000,01,01,01,0,0);
        return DateUtil.localDateTime2DateTime(ldt);
    }
    public static LocalDateTime getDefaultLocalDateTime() {
        return LocalDateTime.of(2000,01,01,01,0,0);
    }

    public static LocalDate getToay_LocalDateUTC() {
        return ZonedDateTime.now(ZoneOffset.UTC).toLocalDate();
    }
}
