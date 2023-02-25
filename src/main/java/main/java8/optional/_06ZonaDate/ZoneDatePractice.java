package main.java8.optional._06ZonaDate;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZoneDatePractice {
    public static void main(String[] args) {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        Instant instant = Instant.now();
        LocalDateTime localDateTime = LocalDateTime.parse("2023-02-23T14:13:13");
        Instant instant1 = Instant.parse("2023-02-23T12:15:58.889083100Z");


        ZonedDateTime zonedDateTime1 = ZonedDateTime.ofInstant(instant1,ZoneId.of(ZoneId.SHORT_IDS.get("MIT")));
        System.out.println(instant1);
        System.out.println(zonedDateTime1);
    }
}
