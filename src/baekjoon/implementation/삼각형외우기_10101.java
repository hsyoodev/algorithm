package baekjoon.implementation;

import java.util.Scanner;

public class 삼각형외우기_10101 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int angle1 = scanner.nextInt();
        int angle2 = scanner.nextInt();
        int angle3 = scanner.nextInt();
        int sum = angle1 + angle2 + angle3;

        if (sum != 180) {
            System.out.print("Error");
        } else {
            if (angle1 == angle2 && angle2 == angle3) {
                System.out.print("Equilateral");
            } else if (angle1 == angle2 || angle1 == angle3 || angle2 == angle3) {
                System.out.print("Isosceles");
            } else {
                System.out.print("Scalene");
            }
        }
    }
}
