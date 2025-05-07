package work.task;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BracketGenerator {

    // Рекурсивная функция для генерации правильных скобочных выражений
    public static void generateBrackets(int n, int openCount, int closeCount, String currentStr, List<String> results) {
        // Когда длина строки равна 2 * N, это правильное выражение
        if (currentStr.length() == 2 * n) {
            results.add(currentStr);
            return;
        }

        // Если количество открывающих скобок меньше N, добавляем открывающую скобку
        if (openCount < n) {
            generateBrackets(n, openCount + 1, closeCount, currentStr + "(", results);
        }

        // Если количество закрывающих скобок меньше открывающих, добавляем закрывающую скобку
        if (closeCount < openCount) {
            generateBrackets(n, openCount, closeCount + 1, currentStr + ")", results);
        }
    }

    public static void main(String[] args) {
        // Ввод числа N
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число повторяющихся скобок: ");
        int n = scanner.nextInt();

        // Список для хранения всех правильных скобочных выражений
        List<String> result = new ArrayList<>();

        // Запуск рекурсии для генерации скобочных выражений
        generateBrackets(n, 0, 0, "", result);

        // Вывод результата
        System.out.println("Число правильных скобочных выражений: " + result.size());
        System.out.println("Варианты:");
        for (String str : result) {
            System.out.println(str);
        }
        scanner.close();
    }
}
