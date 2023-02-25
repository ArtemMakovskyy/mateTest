package main.java8.optional._06ZonaDate;


import java.nio.file.StandardOpenOption;
import java.time.*;
import java.util.TimeZone;

public class MainZoneDate {
    public static void main(String[] args) {
//        base();
        base2();

    }

    static void base() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("ZonedDateTime.now() ... " + zonedDateTime);

        TimeZone timeZone = TimeZone.getDefault();
        System.out.println("TimeZone.getDefault() + timeZone.getDisplayName() ... " + timeZone.getDisplayName());
        System.out.println("timeZone.toZoneId() ... " + timeZone.toZoneId());
        System.out.println();

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("localDateTime.toLocalTime() ... " + localDateTime.toLocalTime());
        System.out.println();
    }

    static void base2() {
        ZonedDateTime australiaTime = ZonedDateTime
                .of(LocalDateTime.now(), ZoneId.of(ZoneId.SHORT_IDS.get("AET")));
        System.out.println("australiaTime ... " + australiaTime);

        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("zonedDateTime ... " + zonedDateTime);

        ZoneId australiaZoneId = ZoneId.of(ZoneId.SHORT_IDS.get("AET"));
        ZoneOffset offset = australiaZoneId.getRules().getOffset(LocalDateTime.now());
        System.out.println(offset);

        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.now(), offset);
        System.out.println(localDateTime);
        System.out.println();
    }
}
