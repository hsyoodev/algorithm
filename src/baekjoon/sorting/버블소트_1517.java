package baekjoon.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 버블소트_1517 {
    private static int[] A;
    private static sData[] M;
    private static long swap = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = new int[N + 1];
        M = new sData[N + 1];
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
                    M[m] = new sData(A[mv2], mv2);
                    mv2++;
                } else {
                    M[m] = new sData(A[mv1], mv1);
                    mv1++;
                }
            } else {
                if (mv1 >= s2 && mv2 <= e) {
                    M[m] = new sData(A[mv2], mv2);
                    mv2++;
                } else {
                    M[m] = new sData(A[mv1], mv1);
                    mv1++;
                }
            }
            m++;
        }

        int diff = 0;
        for (int j = s; j <= e; j++) {
            diff = M[j].index - j;
            if (diff > 0) {
                swap += diff;
            }
            A[j] = M[j].value;
        }
    }
}

class sData {
    int value;
    int index;

    public sData(int value, int index) {
        this.value = value;
        this.index = index;
    }
}
