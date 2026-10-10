import java.util.Scanner;
public class Main {
    public static long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Инициализация массива как в Си
        int[] numbers = {5, 10, 15, 20, 25, 30, 35, 40};

        int sum = 0;

        // Вычисление суммы в цикле for
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }

        double average = (double) sum / numbers.length;

        System.out.println("Сумма элементов массива: " + sum);
        System.out.println("Среднее арифметическое: " + average);


        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();

        int[] nums = new int[size];

        // Ввод элементов массива
        System.out.println("Введите " + size + " целых чисел:");
        for (int i = 0; i < size; i++) {
            nums[i] = scanner.nextInt();
        }

        // Сумма с помощью do-while
        int sumDoWhile = 0;
        int i = 0;
        do {
            sumDoWhile += nums[i];
            i++;
        } while (i < nums.length);
        System.out.println("Сумма (do-while): " + sumDoWhile);

        // Сумма с помощью while
        int sumWhile = 0;
        int j = 0;
        while (j < nums.length) {
            sumWhile += nums[j];
            j++;
        }
        System.out.println("Сумма (while): " + sumWhile);

        // Поиск максимума и минимума
        int max = nums[0];
        int min = nums[0];
        for (int k = 1; k < nums.length; k++) {
            if (nums[k] > max) max = nums[k];
            if (nums[k] < min) min = nums[k];
        }

        System.out.println("Максимальный элемент: " + max);
        System.out.println("Минимальный элемент: " + min);

        System.out.println("Аргументы командной строки:");
        for (i = 0; i < args.length; i++) {
            System.out.println("Аргумент [" + i + "]: " + args[i]);
        }
        for (i = 1; i <= 10; i++) {
            double harmonic = 1.0 / i;
            System.out.println("1/n " + i + " "+ harmonic);
        }
        System.out.println("Введите a:");
        int a= scanner.nextInt();
        System.out.println(factorial(a));
    }
}
