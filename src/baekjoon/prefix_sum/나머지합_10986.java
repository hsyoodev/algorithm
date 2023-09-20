package baekjoon.prefix_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 나머지합_10986 {
    private static long answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] prefixSum = new long[N + 1];
        long[] remainderCount = new long[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            prefixSum[i] = prefixSum[i - 1] + Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i < N + 1; i++) {
            int remainder = (int) (prefixSum[i] % M);
            if (remainder == 0) {
                answer++;
            }
            remainderCount[remainder]++;
        }
        combination(remainderCount, M);
        System.out.print(answer);
    }
    public static void combination(long[] remainderCount, int M) {
        // remainderCount[i]개의 원소를 갖는 집합에서 2개의 원소를 선택
        for (int i = 0; i < M; i++) {
            if (remainderCount[i] > 1) {
                answer += (remainderCount[i] * (remainderCount[i] - 1) / 2);
            }
        }
    }
}