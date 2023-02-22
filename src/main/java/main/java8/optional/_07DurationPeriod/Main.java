package main.java8.optional._07DurationPeriod;

import java.time.*;

public class Main {
    public static void main(String[] args) {
//        base();
        Duration duration = Duration.ofHours(1);
        LocalDateTime couponReleasedAt = LocalDateTime
                .of(LocalDate.now(), LocalTime.of(10, 00));

        boolean isValid = couponReleasedAt.plus(duration)
                .isAfter(LocalDateTime.now());
        System.out.println(isValid);

    }

    static void base() {
        Duration duration = Duration.ofHours(5);
        Period period = Period.ofYears(10);

        LocalDateTime now = LocalDateTime.now();

        System.out.println(now);
        System.out.println(now.plus(duration));
        System.out.println(now.plus(period));
        System.out.println(now.plus(period).plus(duration));
    }
}
