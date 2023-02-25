package main.java8.optional._07DurationPeriod;

import java.time.*;

public class MainDurationPeriod {
    public static void main(String[] args) {
//        base();
//        base2();
        base3();


    }

    static void base() {
        Duration durationMillis = Duration.ofMillis(5);
        Duration durationHours = Duration.ofHours(5);
        Duration durationDays = Duration.ofDays(5);


        Period periodOfDays = Period.ofDays(5);
        Period periodOfMonths = Period.ofMonths(5);
        Period periodOfYears = Period.ofYears(10);

        LocalDateTime now = LocalDateTime.now();

        System.out.println("LocalDateTime now                           ... " + now);
        System.out.println("now.plus(durationHours)                     ... " + now.plus(durationHours));

        System.out.println("now.plus(periodOfYears).plus(durationHours) ... "
                + now.plus(periodOfYears).plus(durationHours));
    }

    static void base2() {
        Duration duration = Duration.ofHours(1);
        LocalDateTime couponReleasedAt = LocalDateTime
                .of(LocalDate.now(), LocalTime.of(10, 0));

        boolean isValid = couponReleasedAt.plus(duration)
                .isAfter(LocalDateTime.now());
        System.out.println(isValid);
    }
    static void base3() {
        Duration durationHours = Duration.ofHours(48);
        LocalDateTime couponReleasedAt
                = LocalDateTime.of(LocalDate.now(),LocalTime.of(9,05));
        System.out.println("LocalDateTime.now() ... " + LocalDateTime.now());
        System.out.println("couponReleasedAt    ... " + couponReleasedAt);

        boolean after = couponReleasedAt.plus(durationHours)
                .isAfter(LocalDateTime.now().plus(durationHours));

        System.out.println(after);


    }
}
