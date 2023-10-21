package baekjoon.prefix_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] prefixSum = new int[N + 1];
        int answer = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            prefixSum[i] += Integer.parseInt(st.nextToken()) + prefixSum[i - 1];
        }
        for (int i = 1; i < N + 1; i++) {
            if (prefixSum[i] == M) {
                answer++;
            }
        }
        for (int i = 1; i < N; i++) {
            for (int j = i + 1; j < N + 1; j++) {
                if (prefixSum[j] - prefixSum[i] == M) {
                    answer++;
                }
            }
        }
        System.out.print(answer);
    }
}
