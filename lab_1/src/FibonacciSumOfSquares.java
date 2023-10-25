import java.util.Scanner;

/**
 * Представляє число Фібоначчі разом з його номером і значенням.
 */
class FibonacciNumber {
    private int number;
    private long value;

    /**
     * Конструктор для створення об'єкту FibonacciNumber.
     *
     * @param number Номер числа Фібоначчі.
     * @param value  Значення числа Фібоначчі.
     */
    public FibonacciNumber(int number, long value) {
        this.number = number;
        this.value = value;
    }

    /**
     * Отримати номер числа Фібоначчі.
     *
     * @return Номер числа Фібоначчі.
     */
    public int getNumber() {
        return number;
    }

    /**
     * Отримати значення числа Фібоначчі.
     *
     * @return Значення числа Фібоначчі.
     */
    public long getValue() {
        return value;
    }
}

/**
 * Головний клас програми для обчислення суми квадратів перших N чисел Фібоначчі.
 */
public class FibonacciSumOfSquares {
    /**
     * Конструктор за замовчуванням. Клас має пустий конструктор.
     */
    public FibonacciSumOfSquares() {
        // Пустий конструктор за замовчуванням.
    }
    /**
     * Головний метод програми.
     *
     * @param args Аргументи командного рядка.
     */
    public static void main(String[] args) {
        int n;

        if (args.length > 0) {
            try {
                n = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.err.println("Invalid input. Please enter a valid number for N.");
                return;
            }
        } else {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter the value of N: ");
                if (scanner.hasNextInt()) {
                    n = scanner.nextInt();
                } else {
                    System.err.println("Invalid input. Please enter a valid number for N.");
                    scanner.close();
                    return;
                }
                scanner.close();
        }

        if (n < 1) {
            System.err.println("N must be a positive integer.");
            return;
        }

        long sumOfSquares = calculateFibonacciSumOfSquares(n);

        System.out.println("Sum of squares of the first " + n + " Fibonacci numbers: " + sumOfSquares);
    }

    /**
     * Обчислити суму квадратів перших N чисел Фібоначчі.
     *
     * @param n Кількість чисел Фібоначчі для обчислення.
     * @return Сума квадратів перших N чисел Фібоначчі.
     */
    public static long calculateFibonacciSumOfSquares(int n) {
        long sumOfSquares = 0;
        long fibPrev = 0;
        long fibCurrent = 1;

        for (int i = 1; i <= n; i++) {
            long fibNext = fibPrev + fibCurrent;
            sumOfSquares += fibCurrent * fibCurrent;
            fibPrev = fibCurrent;
            fibCurrent = fibNext;
        }

        return sumOfSquares;
    }
}