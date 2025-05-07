package work.task;

import java.util.Scanner;

public class CatalanNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество пар скобок (N): ");
        int N = scanner.nextInt();
        System.out.println("Число правильных скобочных выражений: " + countCatalanNumber(N));
    }

    public static int countCatalanNumber(int n) {
        if (n == 0) return 0;
        int[] catalan = new int[n + 1];
        catalan[0] = 1;

        for (int i = 1; i <= n; i++) {
            catalan[i] = 0;
            System.out.print("C(" + i + ") = ");
            for (int j = 0; j < i; j++) {
                catalan[i] += catalan[j] * catalan[i - 1 - j];
                if (j > 0) {
                    System.out.print(" + ");
                }
                System.out.print("C(" + j + ") * C(" + (i - 1 - j) + ")");
            }
            System.out.println(" = " + catalan[i]);
        }
        return catalan[n];
    }
}
