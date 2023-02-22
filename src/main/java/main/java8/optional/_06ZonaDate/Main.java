package main.java8.optional._06ZonaDate;


import java.time.*;
import java.util.TimeZone;

public class Main {
    public static void main(String[] args) {
//        base();
        ZonedDateTime australiaTime = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of(ZoneId.SHORT_IDS.get("AET")));
        System.out.println(australiaTime);

        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);

        ZoneId australiaZoneId = ZoneId.of(ZoneId.SHORT_IDS.get("AET"));
        ZoneOffset offset = australiaZoneId.getRules().getOffset(LocalDateTime.now());
        System.out.println(offset);

        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.now(),offset);
        System.out.println(localDateTime);

    }

    static void base() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);

        TimeZone timeZone = TimeZone.getDefault();
        System.out.println(timeZone.getDisplayName());
        System.out.println(timeZone.toZoneId());

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime.toLocalTime());
    }
}
