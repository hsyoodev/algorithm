package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2343_기타_레슨 {

    private static int[] minutes;
    private static int N;
    private static int M;
    private static int start = 0;
    private static int end = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        minutes = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            minutes[i] = Integer.parseInt(st.nextToken());
        }

        start = Arrays.stream(minutes).max().getAsInt();
        end = Arrays.stream(minutes).sum();

        binarySearch();

        System.out.print(start);
    }

    private static void binarySearch() {
        while (start <= end) {
            int middle = (start + end) / 2;
            int sum = 0;
            int count = 0;

            for (int i = 0; i < N; i++) {
                if (sum + minutes[i] > middle) {
                    sum = 0;

                    count++;
                }

                sum += minutes[i];
            }

            if (sum != 0) {
                count++;
            }

            if (count > M) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
    }

}
