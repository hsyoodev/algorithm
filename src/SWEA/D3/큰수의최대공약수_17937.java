package SWEA.D3;

import java.util.Scanner;

public class 큰수의최대공약수_17937 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            String A = sc.next();
            String B = sc.next();
            String gcdAB = "1";
            if (A.equals(B)) {
                gcdAB = A;
            }
            System.out.printf("#%d %s\n", test_case, gcdAB);
        }
    }
}
