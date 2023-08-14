package baekjoon.prefix_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 나머지합_10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] sumArr = new long[N + 1];
        long[] cntArr = new long[M];
        long answer = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            sumArr[i] = sumArr[i - 1] + Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i < N + 1; i++) {
            int divNum = (int) (sumArr[i] % M);
            if (divNum == 0) {
                answer++;
            }
            cntArr[divNum]++;
        }
        for (int i = 0; i < M; i++) {
            if (cntArr[i] > 1) {
                answer += (cntArr[i] * (cntArr[i] - 1) / 2);
            }
        }
        System.out.print(answer);
    }
}