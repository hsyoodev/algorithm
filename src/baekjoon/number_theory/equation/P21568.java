package baekjoon.number_theory.equation;

import java.util.ArrayList;
import java.util.Scanner;

public class P21568 {
    static ArrayList<>
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();
        int gcd = GCD(A, B);
    }

    public static int GCD(int A, int B) {
        while (A % B != 0) {
            int temp = B;
            B = A % B;
            A = temp;
        }
        return A;
    }
}

class QuotientAndRemainder {
    public int quotient;
    public int remainder;
    public QuotientAndRemainder(int quotient, int remainder) {
        this.quotient = quotient;
        this.remainder = remainder;
    }
}
