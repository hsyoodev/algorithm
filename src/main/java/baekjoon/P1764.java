package baekjoon;

import java.io.*;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/11866
public class P1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        // 듣도 못한 사람의 수
        int N = Integer.parseInt(stringTokenizer.nextToken());
        // 보도 못한 사람의 수
        int M = Integer.parseInt(stringTokenizer.nextToken());
        // 듣도 못한 사람의 명단
        Set<String> heardNames = new HashSet<>();
        for (int i = 0; i < N; i++) {
            heardNames.add(bufferedReader.readLine());
        }
        // 듣보잡의 명단
        PriorityQueue<String> heardSeeNames = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            String name = bufferedReader.readLine();
            // 듣보잡이면
            if (heardNames.contains(name)) {
                heardSeeNames.offer(name);
            }
        }
        // 듣보잡의 수
        bufferedWriter.write(String.valueOf(heardSeeNames.size()));
        bufferedWriter.newLine();
        // 듣보잡의 명단 사전순으로
        while (!heardSeeNames.isEmpty()) {
            bufferedWriter.write(heardSeeNames.poll());
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
