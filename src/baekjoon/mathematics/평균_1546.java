package baekjoon.mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class 평균_1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] scores = IntStream.range(0,N)
                .map(e->Integer.parseInt(st.nextToken()))
                .sorted()
                .toArray();
        int M = scores[N - 1];
        IntStream.of(scores)
                .mapToDouble(e->e*100.0/M)
                .average()
                .ifPresent(System.out::print);
    }
}
