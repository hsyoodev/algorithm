package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1717
public class P1717 {
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        // 집합의 개수
        int n = Integer.parseInt(stringTokenizer.nextToken());
        // 연산의 개수
        int m = Integer.parseInt(stringTokenizer.nextToken());
        // n + 1개의 집합
        parents = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            parents[i] = i;
        }
        // m개의 줄에는 각각의 연산이 주어진다.
        for (int i = 0; i < m; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int operation = Integer.parseInt(stringTokenizer.nextToken());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            switch (operation) {
                // 합집합 연산
                case 0:
                    union(a, b);
                    break;
                // 두 원소가 같은 집합에 포함되어 있는지를 확인하는 연산
                case 1:
                    bufferedWriter.write(parents[findParent(a)] == parents[findParent(b)] ? "YES" : "NO");
                    bufferedWriter.newLine();
                    break;
            }
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    public static int findParent(int x) {
        if (x == parents[x]) {
            return x;
        }
        return parents[x] = findParent(parents[x]);
    }

    public static void union(int a, int b) {
        int parentA = findParent(a);
        int parentB = findParent(b);

        if (parentA != parentB) {
            parents[parentB] = parentA;
        }
    }
}
