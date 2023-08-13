package baekjoon.prefix_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 나머지합_10986 {
    private static int[] intArr;
    private static int count = 0;
    private static Set<String> check = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        intArr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            int A = Integer.parseInt(st.nextToken());
            if (A % M == 0) {
                count++;
            }
            intArr[i] = intArr[i - 1] + A;
        }
        test(1, N, intArr[N], M);
        System.out.print(count);
    }
    private static void test(int start, int end, int sum, int num) {
        if (start == end) {
            return;
        }
        if (sum % num == 0) {
            count++;
        }
        if (!check.contains(start + "" + end)){
            check.add(start + "" + end);
            if (!check.contains((start + 1) + "" + end)){
                test(start + 1, end, intArr[end] - intArr[start], num);
            }
            if (!check.contains(start + "" + (end - 1))){
                test(start, end - 1, intArr[end - 1] - intArr[start - 1], num);
            }
        }
    }
}