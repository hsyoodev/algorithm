package baekjoon.mathematics;

import java.util.Scanner;

public class Squares_6887 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tiles = scanner.nextInt();
        int length = (int) Math.sqrt(tiles);
        System.out.print("The largest square has side length " + length + ".");
    }
}
