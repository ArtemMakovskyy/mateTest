package main.java8.optional._05Time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class MainLocalTime {
    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now();
        System.out.println("currentDate // LocalDate ... "  + currentDate);
        System.out.println(currentDate.plusDays(4));
        System.out.println(currentDate.plusYears(4).plusDays(1));
        System.out.println(currentDate.format(DateTimeFormatter.ofPattern("dd-yyyy-MM")));
        System.out.println(currentDate);

        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println();
        System.out.println("LocalDateTime.now() " + currentDateTime);
        System.out.println();
        System.out.println("currentDateTime.toLocalTime() " + currentDateTime.toLocalTime());
        LocalTime localTime = currentDateTime.toLocalTime();
        System.out.println(localTime);

        LocalTime localTime1 = currentDateTime.toLocalTime();
        LocalDate localTime2 = currentDateTime.toLocalDate();
        System.out.println("currentDateTime.toLocalTime() ... " + localTime1);
        System.out.println("currentDateTime.toLocalDate() ... " + localTime2);
        System.out.println();

        LocalDate parse = LocalDate.parse("2020-11-22");
        System.out.println("LocalDate parse ... " + parse);
        System.out.println(parse.getYear());
        System.out.println(parse.getMonth());
        System.out.println(parse.getDayOfMonth());
        System.out.println(parse.getChronology());


    }
}
