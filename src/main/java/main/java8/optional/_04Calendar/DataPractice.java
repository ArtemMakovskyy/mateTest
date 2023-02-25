package main.java8.optional._04Calendar;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DataPractice {
    public static void main(String[] args) {
//        dateInf();
        calendarInf();
    }

    public static void calendarInf() {
        int addTime = 2;
        /*
        Calendar
         - как получить только время
         - мы не можем добавить несколько дней или лет
         - нужно использовать посторонний класс, чтоб получить информацию
         */
        Calendar calendar = Calendar.getInstance();
        System.out.println("calendar  ..." + calendar);
        System.out.println();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        System.out.println("simpleDateFormat.format(calendar.getTime()) ... " + simpleDateFormat.format(calendar.getTime()));

        calendar.add(1,1);
        System.out.println("simpleDateFormat.format(calendar.getTime()) ... " + simpleDateFormat.format(calendar.getTime()));

        calendar.add(Calendar.DAY_OF_YEAR,addTime);
        calendar.add(Calendar.HOUR,addTime);
        calendar.add(Calendar.MONTH,addTime);
        calendar.add(Calendar.YEAR,addTime);
        calendar.add(Calendar.MINUTE,addTime);
        System.out.println("simpleDateFormat.format(calendar.getTime()) ... " + simpleDateFormat.format(calendar.getTime()));


        Calendar calendar1 = Calendar.getInstance();
        calendar1.add(Calendar.HOUR,5);
        int hours = calendar1.get(Calendar.HOUR);
        int minutes = calendar1.get(Calendar.MINUTE);
        System.out.println("hours ... " + hours + " minutes " + minutes);

//        Date time = calendar1.getTime();
//        System.out.println(time);
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
        System.out.println("date ..." + date);
        System.out.println("date.getTime() ..." + date.getTime());

        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        System.out.println("simpleDateFormat.format(date) ..." + simpleDateFormat.format(date));
    }
}
