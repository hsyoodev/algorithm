package baekjoon.sorting;

import java.io.*;

public class 수정렬하기2_2751 {
    private static int[] A;
    private static int[] M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        A = new int[N + 1];
        M = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        mergesort(1, N);
        for (int i = 1; i < N + 1; i++) {
            bw.write(A[i] + "\n");
        }
        bw.flush();
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
                if (A[mv1] >= A[mv2]) {
                    M[m] = A[mv2];
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