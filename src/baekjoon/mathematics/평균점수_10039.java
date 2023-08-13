package baekjoon.mathematics;

import java.util.Scanner;
import java.util.stream.IntStream;

public class 평균점수_10039 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print((int) IntStream.range(0,5).map(e->{
            int score = sc.nextInt();
            return score < 40 ? 40 : score;
        }).average().getAsDouble());
    }
}
