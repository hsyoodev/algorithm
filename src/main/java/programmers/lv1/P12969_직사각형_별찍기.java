package programmers.lv1;

import java.util.Scanner;

public class P12969_직사각형_별찍기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(("*".repeat(a) + "\n").repeat(b));
    }

}
