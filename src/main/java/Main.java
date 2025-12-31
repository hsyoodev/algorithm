import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        for (int i = 2; i <= 9; i++) {
            if (isPrimeNumber(i)) {
                DFS(i, N);
            }
        }
    }

    private static void DFS(int number, int length) {
        if (String.valueOf(number).length() == length) {
            System.out.println(number);

            return;
        }

        for (int i = 1; i <= 9; i++) {
            int nextNumber = Integer.parseInt(String.valueOf(number) + i);

            if (isPrimeNumber(nextNumber)) {
                DFS(nextNumber, length);
            }
        }
    }

    private static boolean isPrimeNumber(int number) {
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

}
