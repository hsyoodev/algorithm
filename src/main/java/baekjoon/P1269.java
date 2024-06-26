package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1269
public class P1269 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        // A의 원소의 개수
        int sizeOfA = Integer.parseInt(stringTokenizer.nextToken());
        // B의 원소의 개수
        int sizeOfB = Integer.parseInt(stringTokenizer.nextToken());
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        // 집합 A
        Set<Integer> A = new HashSet<>();
        for (int i = 0; i < sizeOfA; i++) {
            A.add(Integer.parseInt(stringTokenizer.nextToken()));
        }
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        // 집합 B
        Set<Integer> B = new HashSet<>();
        for (int i = 0; i < sizeOfB; i++) {
            B.add(Integer.parseInt(stringTokenizer.nextToken()));
        }
        // B - A
        for (int elementOfA : A) {
            if (B.contains(elementOfA)) {
                sizeOfB--;
            }
        }
        // A - B
        for (int elementOfB : B) {
            if (A.contains(elementOfB)) {
                sizeOfA--;
            }
        }
        System.out.print(sizeOfA + sizeOfB);
    }
}
