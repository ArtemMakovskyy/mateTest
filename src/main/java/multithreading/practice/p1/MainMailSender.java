package multithreading.practice.p1;

import java.util.ArrayList;
import java.util.List;
import lombok.SneakyThrows;

public class MainMailSender {
    public static void main(String[] args) throws InterruptedException {
        final long startTime = System.currentTimeMillis();
        int NUMBER_OF_SEND_BY_THREAD = 5;
        int mailsNumber = 10000;

        final List<String> sendText = crateMails(mailsNumber, "send text");
        List<Thread> threadList = new ArrayList<>();
        System.out.println(sendText.size() / NUMBER_OF_SEND_BY_THREAD);

        for (int i = 0; i < 5; i++) {
            List<String> emails = new ArrayList<>(sendText.subList(i, i + 2000));
            EmailSenderThread emailSenderThread = new EmailSenderThread(emails);
            threadList.add(new Thread(emailSenderThread));
        }

        System.out.println(threadList.size());
        for (Thread thread : threadList) {
            thread.start();
//            thread.join();
        }

//        for (Thread thread : threadList) {
//            thread.join();
//        }
        final long time = System.currentTimeMillis() - startTime;
        System.out.println("finish" + " " + time);
    }

    static List<String> crateMails(int number, String textNotification) {
        List<String> mails = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            mails.add(textNotification);
        }
        return mails;
    }

}

class EmailSenderThread implements Runnable {
    private List<String> mails;

    public EmailSenderThread(List<String> mails) {
        this.mails = mails;
    }

    @SneakyThrows
    @Override
    public void run() {
        System.out.println(">>>>>>>>>>>>>>> srate " + Thread.currentThread().getName());
        for (String mail : mails) {
            send(mail);
        }
        System.out.println("<<<<<<<<<<<<<<<<< end " + Thread.currentThread().getName());
    }

    private void send(String mail) throws InterruptedException {
        System.out.println(mail + " " + Thread.currentThread().getName());
        Thread.sleep(1);
    }
}