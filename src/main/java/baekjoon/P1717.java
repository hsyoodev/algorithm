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
        int n = Integer.parseInt(stringTokenizer.nextToken());
        parents = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            parents[i] = i;
        }
        // 연산의 개수
        int m = Integer.parseInt(stringTokenizer.nextToken());
        for (int i = 0; i < m; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String operation = stringTokenizer.nextToken();
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            switch (operation) {
                // 합집합은 0 a b의 형태로 입력이 주어진다.
                case "0":
                    unionFind(a, b);
                    break;
                // 두 원소가 같은 집합에 포함되어 있는지를 확인하는 연산은 1 a b의 형태로 입력이 주어진다.
                case "1":
                    bufferedWriter.write(parents[findParent(a)] == parents[findParent(b)] ? "YES" : "NO");
                    bufferedWriter.newLine();
                    break;
            }
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    public static int findParent(int node) {
        if (node == parents[node]) {
            return node;
        }
        return parents[node] = findParent(parents[node]);
    }

    public static void unionFind(int a, int b) {
        int parentA = findParent(a);
        int parentB = findParent(b);
        if (parentA < parentB) {
            parents[parentB] = parentA;
        } else {
            parents[parentA] = parentB;
        }
    }
}
