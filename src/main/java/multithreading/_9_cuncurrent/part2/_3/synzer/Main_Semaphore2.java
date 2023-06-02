package multithreading._9_cuncurrent.part2._3.synzer;

import java.util.concurrent.Semaphore;
//https://pro-java.ru/parallelizm-v-java/klass-semaphore-primery-realizacii-koda-v-java/
public class Main_Semaphore2 {
    public static void main(String[] args) {
        Service q = new Service();
        new Consumer(q);
        new Producer(q);
    }
}

class Service {

    int n;

    // начать с недоступного семафора потребителя

    static Semaphore semCon = new Semaphore(0);
    static Semaphore semProd = new Semaphore(1);

    void get() {
        try {
            semCon.acquire();
        } catch (InterruptedException e) {
            System.out.println("Перехвачено исключение типа InterruptedException");
        }
        System.out.println("Получено: " + n);
        semProd.release();
    }

    void put(int n) {
        try {
            semProd.acquire();
        } catch (InterruptedException e) {
            System.out.println("Перехвачено исключение типа InterruptedException");
        }
        this.n = n;
        System.out.println("Отправлено: " + n);
        semCon.release();
    }
}

class Producer implements Runnable {
    Service service;

    Producer(Service q) {
        this.service = q;
        new Thread(this, "Producer").start();
    }

    public void run() {
        for (int i = 0; i < 7; i++) {
            service.put(i);
        }
    }
}

class Consumer implements Runnable {
    Service service;

    Consumer(Service q) {
        this.service = q;
        new Thread(this, "Consumer").start();
    }

    public void run() {
        for (int i = 0; i < 7; i++) {
            service.get();
        }
    }
}