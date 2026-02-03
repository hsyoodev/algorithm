import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            binarySearch(0, N - 1, Integer.parseInt(st.nextToken()));
        }

        br.close();
    }

    private static void binarySearch(int startIndex, int endIndex, int target) {
        if (startIndex < endIndex) {
            System.out.println(0);

            return;
        }

        int middleIndex = (startIndex + endIndex) / 2;

        if (A[middleIndex] > target) {
            binarySearch(startIndex, middleIndex - 1, target);
        } else if (A[middleIndex] < target) {
            binarySearch(middleIndex + 1, endIndex, target);
        } else {
            System.out.println(1);
        }
    }

}
