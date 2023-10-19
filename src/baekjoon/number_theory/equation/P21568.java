package baekjoon.number_theory.equation;

import java.util.Scanner;
import java.util.Stack;

public class P21568 {
    static Stack<Integer> quotients = new Stack<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();
        int gcd = GCD(A, B);
        int x = 1;
        int y = 0;
        while (!quotients.isEmpty()) {
            int q = quotients.pop();
            int prevX = x;
            int prevY = y;
            x = prevY;
            y = prevX - (prevY * q);
        }
        int K = C / gcd;
        x *= K;
        y *= K;
        boolean isAxByC = A * x + B * y == C;
        System.out.print(isAxByC ? x + " " + y : -1);
    }

    public static int GCD(int A, int B) {
        while (B != 0) {
            int quotient = A / B;
            quotients.push(quotient);
            int temp = B;
            B = A % B;
            A = temp;
        }
        return A;
    }
}
