package baekjoon.data_structures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class P1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        // 듣도 못한 사람의 수
        int N = Integer.parseInt(stringTokenizer.nextToken());
        // 보도 못한 사람의 수
        int M = Integer.parseInt(stringTokenizer.nextToken());
        // 듣도 보도 못한 사람의 명단을 구하기
        Map<String, Integer> names = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String name = bufferedReader.readLine();
            names.put(name, 1);
        }
        for (int i = 0; i < M; i++) {
            String name = bufferedReader.readLine();
            names.put(name, names.getOrDefault(name, 0) + 1);
        }
        Map<String, Integer> answer = names.entrySet().stream()
                .filter(e -> e.getValue() >= 2)
                .collect(Collectors.toMap(
                        e -> e.getKey(),
                        e -> e.getValue()
                ));
        // 듣보잡 수
        System.out.println(answer.size());
        // 듣보잡 명단
        answer.keySet().stream()
                .sorted()
                .forEach(System.out::println);
    }
}
