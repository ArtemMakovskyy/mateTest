package main.java8.optional._04Calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataPractice {
    public static void main(String[] args) {
//        dateInf();
        calendarInf();
    }

    public static void calendarInf() {
                /*
        Calendar
         - как получить только время
         - мы не можем добавить несколько дней или лет
         - нужно использовать посторонний класс, чтоб получить информацию
         */
        Calendar calendar = Calendar.getInstance();
//        System.out.println(calendar);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        System.out.println(simpleDateFormat.format(calendar.getTime()));
        calendar.add(1,1);
        System.out.println(simpleDateFormat.format(calendar.getTime()));
        calendar.add(Calendar.DAY_OF_YEAR,1);
        calendar.add(Calendar.HOUR,1);
        calendar.add(Calendar.MONTH,1);
        System.out.println(simpleDateFormat.format(calendar.getTime()));
        System.out.println(calendar.get(Calendar.HOUR));
    }

    public static void dateInf() {
                /*
        DATA
         - как получить только время
         - сложно понять что означают цифры
         - как получить только время
         */
        Date date = new Date();
        //can't add days
        System.out.println(date);
        System.out.println(date.getTime());

        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        System.out.println(simpleDateFormat.format(date));
    }
}
