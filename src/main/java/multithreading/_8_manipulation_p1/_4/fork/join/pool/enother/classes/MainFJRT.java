package multithreading._8_manipulation_p1._4.fork.join.pool.enother.classes;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

//https://www.youtube.com/watch?v=c2n-mjlLqrs
public class MainFJRT {
    public static void main(String[] args) {

        int[] list = new int[100_000_000];
        for (int i = 0; i < list.length; i++) {
            list[i] = (int) (Math.random()*1_000_000_000);
        }
        System.out.println(findMAx(list));
    }

    private static int findMAx(int[] list) {
        RecursiveTask<Integer> recursiveTask = new FindingMax(0, list.length, list);
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        return forkJoinPool.invoke(recursiveTask);
    }
}

class FindingMax extends RecursiveTask<Integer> {
    int left;
    int right;
    int[] list;

    public FindingMax(int left, int right, int[] list) {
        this.left = left;
        this.right = right;
        this.list = list;
    }

    @Override
    protected Integer compute() {
        if (right - left < 100_000) {
            int currentMax = 0;
            for (int i = left; i < right; i++){
                currentMax = Math.max(currentMax, list[i]);
            }
            return currentMax;
        } else {
            int mid = (left + right) / 2;
            RecursiveTask<Integer> leftRT = new FindingMax(left, mid, list);
            RecursiveTask<Integer> rightRT = new FindingMax(mid, right, list);
            leftRT.fork();
            rightRT.fork();
            return Math.max(leftRT.join(), rightRT.join());
        }
    }
}
