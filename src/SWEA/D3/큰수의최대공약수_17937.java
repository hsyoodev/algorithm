package SWEA.D3;

import java.math.BigInteger;
import java.util.Scanner;

public class 큰수의최대공약수_17937 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            BigInteger A = sc.nextBigInteger();
            BigInteger B = sc.nextBigInteger();
            BigInteger temp = A;
            A= B.mod(A);
            B = temp;
            while (A.compareTo(BigInteger.valueOf(0)) != 0) {
                temp = A;
                A = B.mod(A);
                B = temp;
            }
            System.out.printf("#%d %d\n", test_case, B);
        }
    }
}
