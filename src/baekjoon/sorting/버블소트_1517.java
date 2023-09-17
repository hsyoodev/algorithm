package baekjoon.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 버블소트_1517 {
    private static int[] A;
    private static int[] M;
    private static long swap = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = new int[N + 1];
        M = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        mergesort(1, N);
        System.out.print(swap);
    }

    private static void mergesort(int s, int e) {
        if (s == e) {
            return;
        }

        int s2 = ((s + e) / 2) + 1;
        mergesort(s, s2 - 1);
        mergesort(s2, e);

        int mv1 = s;
        int mv2 = s2;
        int m = s;
        while (m <= e) {
            if (mv1 < s2 && mv2 <= e) {
                if (A[mv1] > A[mv2]) {
                    M[m] = A[mv2];
                    swap += mv2 - m;
                    mv2++;
                } else {
                    M[m] = A[mv1];
                    mv1++;
                }
            } else {
                if (mv1 >= s2 && mv2 <= e) {
                    M[m] = A[mv2];
                    mv2++;
                } else {
                    M[m] = A[mv1];
                    mv1++;
                }
            }
            m++;
        }
        for (int j = s; j <= e; j++) {
            A[j] = M[j];
        }
    }
}
