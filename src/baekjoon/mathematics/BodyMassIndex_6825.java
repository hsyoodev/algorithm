package baekjoon.mathematics;

import java.util.Scanner;

public class BodyMassIndex_6825 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float weight = scanner.nextFloat();
        float height = scanner.nextFloat();
        float BMI = weight / (height * height);

        System.out.print(BMI > 25 ? "Overweight" : (BMI < 18.5 ? "Underweight" : "Normal weight"));
    }
}
