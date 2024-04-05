package multithreading.all.in.one;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import lombok.Data;
import lombok.Getter;

public class G00_Semaphore {
    private static TicketBookingSystem bookingSystem = new TicketBookingSystem(5);
    public static void main(String[] args) {
        start1();
    }

    private static void start1(){
        String user = "User1";
        BookingResult result = bookingSystem.attemptBooking(user);
        System.out.println(result);
    }
}

class TicketBookingSystem {
    private final Semaphore semaphore;
    private int totalSeats;
    private final Lock lock;

    public TicketBookingSystem(int totalSeats) {
        this.totalSeats = totalSeats;
        this.semaphore = new Semaphore(totalSeats);
        this.lock = new ReentrantLock();
    }

    public BookingResult attemptBooking(String user) {
        BookingResult bookingResult;
        lock.lock();
        try {
            semaphore.acquire();
            if (totalSeats > 0) {
                bookingResult = new BookingResult(user, true, "Booking successful.");
                totalSeats--;
            } else {
                bookingResult = new BookingResult(user, false, "No seats available.");
            }
            semaphore.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
        return bookingResult;
    }
}

@Data
class BookingResult{
    private String user;
    private boolean success;
    private String message;

    public BookingResult(String user, boolean success, String message) {
        this.user = user;
        this.success = success;
        this.message = message;
    }
}