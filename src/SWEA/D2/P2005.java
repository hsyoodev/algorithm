package SWEA.D2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P2005 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 1; i <= T; i++) {
            int N = scanner.nextInt();
            System.out.printf("#%d\n", i);
            List<Integer> numbers = new ArrayList<>();
            numbers.add(1);
            for (int j = 0; j < N; j++) {
                for (int number : numbers) {
                    System.out.printf("%d ", number);
                }
                System.out.println();
                List<Integer> tempNumbers = new ArrayList<>(numbers);
                for (int k = 1; k < numbers.size(); k++) {
                    numbers.set(k, tempNumbers.get(k) + tempNumbers.get(k - 1));
                }
                numbers.add(1);
            }
        }
    }
}
