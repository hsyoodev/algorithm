package baekjoon.number_theory.GCD;

import java.io.*;
import java.util.Scanner;

public class P1850 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long A = scanner.nextLong();
        long B = scanner.nextLong();
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
