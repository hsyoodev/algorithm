import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int[][] A = new int[N + 1][N + 1];

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                A[i][j] = i * j;
            }
        }

        int start = 1;
        int end = K;

        while (start <= end) {
            int middle = (start + end) / 2;
            int count = 0;

            for (int i = 1; i < N + 1; i++) {
                count += Math.min(middle / i, N);
            }

            if (count < K) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }

        System.out.print(start);
    }

}
