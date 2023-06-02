package multithreading._8_manipulation_p1.task;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

public class MainVar2 {
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        SumAllNumbersRecursive2 sumAllNumbersRecursive
                = new SumAllNumbersRecursive2(0, 100, 10);
        Long result = forkJoinPool.invoke(sumAllNumbersRecursive);
        System.out.println("Result " + result);
    }
}

class SumAllNumbersRecursive2 extends RecursiveTask<Long> {
    int startNum, endNum, threadsNum;

    public SumAllNumbersRecursive2(int startNum, int endNum, int threadsNum) {
        this.startNum = startNum;
        this.endNum = endNum;
        this.threadsNum = threadsNum;
    }

    @Override
    protected Long compute() {
        if (endNum - startNum < threadsNum) {
            return (long) IntStream.range(startNum, endNum).sum();
        } else {
            int mid = startNum + (endNum - startNum) / 2;
            RecursiveTask<Long> leftTask = new SumAllNumbersRecursive2(startNum, mid, threadsNum);
            RecursiveTask<Long> rightTask = new SumAllNumbersRecursive2(mid, endNum, threadsNum);
            leftTask.fork();
            rightTask.fork();
            return leftTask.join() + rightTask.join();
        }
    }
}