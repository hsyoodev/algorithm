package SWEA.D1;

import java.util.Scanner;

public class P1936 {
    final static int ROCK = 1;
    final static int PAPER = 2;
    final static int SCISSORS = 3;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        String winner = getWinner(A, B);
        System.out.print(winner);
    }

    private static String getWinner(int A, int B) {
        boolean isA = true;
        if (B == ROCK && A == SCISSORS) {
            isA = false;
        } else if (B == PAPER && A == ROCK) {
            isA = false;
        } else if (B == SCISSORS && A == PAPER) {
            isA = false;
        }
        return isA ? "A" : "B";
    }
}
