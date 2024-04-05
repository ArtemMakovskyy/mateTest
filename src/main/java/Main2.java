import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Main2 {
    public static void main(String[] args) {
        System.out.println(LocalDateTime.now());
        // Создание Timestamp из текущей даты и времени
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        System.out.println("Current Timestamp: " + currentTimestamp);

        // Преобразование строки в Timestamp
        String dateTimeString = "2022-02-08 15:30:00";
        Timestamp timestampFromString = Timestamp.valueOf(dateTimeString);
        System.out.println("Timestamp from String: " + timestampFromString);

        // Получение времени в миллисекундах
        long milliseconds = timestampFromString.getTime();
        System.out.println("Milliseconds: " + milliseconds);


    }
}