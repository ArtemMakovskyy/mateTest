package reqursion;

public class Samples {
    public static void main(String[] args) {
//        int number = 5; // Число, для которого нужно вычислить факториал
//        int result = factorial(number); // Вызов рекурсивного метода
//        System.out.println("Факториал числа " + number + " равен " + result); // Вывод результата

//        int n1 = 3;
//        System.out.println("Sum of numbers from 1 to " + n1 + " is " + sumNumbers(n1));


//        int n2 = 5; // Число, для которого нужно вычислить число Фибоначчи
//        int result = fibonacci(n2); // Вызов рекурсивного метода
//        System.out.println("Число Фибоначчи для " + n2 + " равно " + result); // Вывод результата


        int[] array = {1, 2, 3, 4, 5};
        int n = array.length;
        int sum = sumArray(array, n);
        System.out.println("Сумма элементов массива равна " + sum);
    }



    public static int sumArray(int[] array, int n) {
        if (n <= 0) { // Базовый случай: если массив пуст или достигнут конец массива
            return 0;
        } else { // Рекурсивный случай: сумма последнего элемента и оставшихся элементов массива
            return sumArray(array, n - 1) + array[n - 1];
        }
    }

    public static int fibonacci(int n) {
        //recursion
        if (n == 0) { // Базовый случай 1
            return 0;
        } else if (n == 1) { // Базовый случай 2
            return 1;
        } else { // Рекурсивный случай
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
        //while
    }


    public static int sumNumbers(int n) {
        //recursive case
        if (true) {
            if (n == 0) {
                return 0;
            } else {
                return n + (sumNumbers(n - 1));
            }
        }


        int sum = 0;
        //for case
        if (false) {
            for (int i = 0; i <= n; i++) {
                sum += i;
            }
        }

        //wile case
        if (false) {
            int i = 1;
            while (i <= n) {
                sum += i;
                i++;
            }
        }
        return sum;
    }

    public static int factorial(int n) {
        if (n == 0) { // Базовый случай
            return 1;
        } else { // Рекурсивный случай
            return n * factorial(n - 1);
        }
    }

}


