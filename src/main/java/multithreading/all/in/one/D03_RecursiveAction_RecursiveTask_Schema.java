package multithreading.all.in.one;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;
import multithreading._8_manipulation_p1._4.fork.join.pool.MyRecursiveTask;

public class D03_RecursiveAction_RecursiveTask_Schema {
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        // Пример использования RecursiveAction
        MyRecursiveActionDemo myAction = new MyRecursiveActionDemo(0, 10);
        forkJoinPool.invoke(myAction);

        // Пример использования RecursiveTask
        MyRecursiveTaskDemo myTask = new MyRecursiveTaskDemo(0, 10);
        long result = forkJoinPool.invoke(myTask);
        System.out.println("Результат: " + result);
    }
}

// Пример RecursiveAction
class MyRecursiveActionDemo extends RecursiveAction {
    private int start;
    private int end;

    public MyRecursiveActionDemo(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        // Выполнение рекурсивной задачи без возвращаемого значения
        // Пример: обработка элементов массива или изменение состояния объекта
    }
}

// Пример RecursiveTask
class MyRecursiveTaskDemo extends RecursiveTask<Integer> {
    private int start;
    private int end;

    public MyRecursiveTaskDemo(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        // Выполнение рекурсивной задачи с возвращаемым значением
        // Пример: вычисление суммы элементов массива или другая операция, возвращающая результат
        return 0;
    }
}