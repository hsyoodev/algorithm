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
            BigInteger max = BigInteger.valueOf(0);
            for (BigInteger i = BigInteger.valueOf(1); i.multiply(i).compareTo(A) != 1; i = i.add(BigInteger.valueOf(1))) {
                boolean isGCD = true;
                for (BigInteger j = A; j.compareTo(B) != 1; j = j.add(BigInteger.valueOf(1))) {
                    if (j.mod(i) != BigInteger.valueOf(0)) {
                        isGCD = false;
                        break;
                    }
                }
                if (isGCD) {
                    if (max.compareTo(i) == -1) {
                        max = i;
                    }
                }
            }
            System.out.printf("#%d %d\n", test_case, max);
        }
    }
}
