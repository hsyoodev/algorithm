package baekjoon.sorting;

import java.io.*;

public class 수정렬하기3_10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[10001];
        for (int i = 0; i < N; i++) {
            int index = Integer.parseInt(br.readLine());
            A[index]++;
        }
        for (int i = 1; i < 10001; i++) {
            while (A[i]-- != 0) {
                bw.write(i + "\n");
            }
        }
        bw.flush();
    }
}
