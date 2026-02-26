package baekjoon.silver;

import java.util.Scanner;

public class P1541_잃어버린_괄호 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] A = scanner.next().split("\\-");
        long answer = 0;

        for (int i = 0; i < A.length; i++) {
            String[] B = A[i].split("\\+");

            int sum = 0;
            for (int j = 0; j < B.length; j++) {
                sum += Integer.parseInt(B[j]);
            }

            if (A.length >= 2 && i >= 1) {
                answer += (sum * -1);
            } else {
                answer += sum;
            }
        }

        System.out.print(answer);
    }

}
