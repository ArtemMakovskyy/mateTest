package multithreading._4.thread.manipulation.practice3;


public class PackageService {
    String pack;
    boolean transfer = true;

    public synchronized void save(String msg) {
        while (!transfer) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        pack = msg;
        System.out.print(Thread.currentThread().getName() + " <| msg save " + pack);
        transfer = false;
        notify();
    }

    public synchronized String receive() {
        while (transfer) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            Thread.sleep(250);
            System.out.print(" >");
            Thread.sleep(200);
            System.out.print(">");
            Thread.sleep(100);
            System.out.print(">");
            Thread.sleep(200);
            System.out.print(">");
            Thread.sleep(250);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(" msg receive " + pack + " |> " + Thread.currentThread().getName());
        transfer = true;
        notify();
        return pack;
    }
}
