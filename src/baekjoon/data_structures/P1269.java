package baekjoon.data_structures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/1269
public class P1269 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        // 집합 A의 원소의 개수
        int lengthA = Integer.parseInt(stringTokenizer.nextToken());
        // 집합 B의 원소의 개수
        int lengthB = Integer.parseInt(stringTokenizer.nextToken());
        // 집합 A의 모든 원소
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        Set<Integer> A = new HashSet<>();
        for (int i = 0; i < lengthA; i++) {
            A.add(Integer.parseInt(stringTokenizer.nextToken()));
        }
        // 집합 B의 모든 원소
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        Set<Integer> B = new HashSet<>();
        for (int i = 0; i < lengthB; i++) {
            B.add(Integer.parseInt(stringTokenizer.nextToken()));
        }
        int answer = 0;
        // A-B
        answer += (int) A.stream()
                .filter((e) -> !B.contains(e))
                .count();
        // B-A
        answer += (int) B.stream()
                .filter((e) -> !A.contains(e))
                .count();
        // 대칭 차집합의 원소의 개수
        System.out.print(answer);
    }
}
