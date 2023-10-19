package baekjoon.number_theory.GCD;

import java.io.*;
import java.util.StringTokenizer;

public class P1850 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long gcd = GCD(A, B);
        for (int i = 0; i < gcd; i++) {
            bw.write("1");
        }
        bw.flush();
        bw.close();
    }

    public static long GCD(long A, long B) {
        while (B % A != 0) {
            long temp = A;
            A = B % A;
            B = temp;
        }
        return A;
    }
}
