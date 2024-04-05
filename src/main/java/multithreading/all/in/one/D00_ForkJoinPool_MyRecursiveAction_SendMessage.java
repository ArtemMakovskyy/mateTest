package multithreading.all.in.one;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class D00_ForkJoinPool_MyRecursiveAction_SendMessage {
    private static Map<String, String> getMessages(int quantity) {
        Map<String, String> message = new HashMap<>();
        for (int i = 0; i < quantity; i++) {
            message.put("ivan" + i + "@mail.com", "Hello Ivan" + i);
        }
        return message;
    }

    public static void main(String[] args) throws InterruptedException {
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        MyRecursiveActionSendMail recursiveAction
                = new MyRecursiveActionSendMail(getMessages(100));

        forkJoinPool.invoke(recursiveAction);
        Thread.sleep(100);
    }
}

class MyRecursiveActionSendMail extends RecursiveAction {
    private static final int MAXIMUM_QUANTITY_FOR_PROCESSING = 25;
    private final Map<String, String> message;

    public MyRecursiveActionSendMail(Map<String, String> message) {
        this.message = message;
    }

    @Override
    protected void compute() {
        if (message.size() > MAXIMUM_QUANTITY_FOR_PROCESSING) {
            splitTask();
        } else {
            doHardProcess();
        }
    }

    private void splitTask() {
        System.out.println("workload > THRESHOLD. It will split. " +
                message.size() + " " +
                Thread.currentThread().getName());
        final List<MyRecursiveActionSendMail> subTasks = createSubTasks();
        for (MyRecursiveActionSendMail task : subTasks) {
            task.fork();
        }
    }

    private List<MyRecursiveActionSendMail> createSubTasks() {
        int halfSize = message.size() / 2;
        Map<String, String> firstHalf = new HashMap<>();
        Map<String, String> secondHalf = new HashMap<>();

        int count = 0;
        for (Map.Entry<String, String> entry : message.entrySet()) {
            if (count < halfSize) {
                firstHalf.put(entry.getKey(), entry.getValue());
            } else {
                secondHalf.put(entry.getKey(), entry.getValue());
            }
            count++;
        }
        List<MyRecursiveActionSendMail> tasks = new ArrayList<>();
        tasks.add(new MyRecursiveActionSendMail(firstHalf));
        tasks.add(new MyRecursiveActionSendMail(secondHalf));
        return tasks;
    }

    private void doHardProcess() {
        for (Map.Entry<String, String> entry : message.entrySet()) {
            System.out.println(message.size() + ". Sending email to " + entry.getKey() + ": " + entry.getValue()
                  + " ...> " + Thread.currentThread().getName());
        }
    }
}