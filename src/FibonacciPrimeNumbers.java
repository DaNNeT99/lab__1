import java.util.Scanner;

class FibonacciNumber {
    private int number;
    private long value;

    public FibonacciNumber(int number, long value) {
        this.number = number;
        this.value = value;
    }

    public int getNumber() {
        return number;
    }

    public long getValue() {
        return value;
    }
}

public class FibonacciPrimeNumbers {
    // Функція для перевірки, чи є число простим
    public static boolean isPrime(long n) {
        if (n <= 1) {// числа що менші 1 не вважаються простими
            return false;
        }
        if (n <= 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {// числа що діляться на 2/3 без остачі не можуть бути постими
            return false;
        }
        for (long i = 5; i * i <= n; i += 6) {//перевірка на подільність 5,11,17 і тд
            if (n % i == 0 || n % (i + 2) == 0) {// перевірка на подільність 5,7, 11,13 і тд
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть номер числа Фібоначчі: ");
        int n = scanner.nextInt();

        long fib1 = 1;
        long fib2 = 1;
        FibonacciNumber[] fibonacciNumbers = new FibonacciNumber[n];

        // Обчислення та збереження перших N чисел Фібоначчі
        for (int i = 0; i < n; i++) {
            if (i < 2) {
                fibonacciNumbers[i] = new FibonacciNumber(i + 1, 1);
            } else {
                long fibNext = fib1 + fib2;
                fibonacciNumbers[i] = new FibonacciNumber(i + 1, fibNext);
                fib1 = fib2;
                fib2 = fibNext;
            }
        }

        System.out.println("Перші " + n + " чисел Фібоначчі:");
        // Виведення чисел
        for (FibonacciNumber fibNumber : fibonacciNumbers) {
            System.out.println("Число #" + fibNumber.getNumber() + ": " + fibNumber.getValue());
        }
        System.out.println("Прості числа серед перших " + n + " чисел Фібоначчі:");
        // перевірка, які з них прості
        for (FibonacciNumber fibNumber : fibonacciNumbers) {
            if (isPrime(fibNumber.getValue())) {
                System.out.println("Число #" + fibNumber.getNumber() + ": " + fibNumber.getValue());
            }
        }
    }
}
