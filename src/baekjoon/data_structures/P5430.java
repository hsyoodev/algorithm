package baekjoon.data_structures;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

// https://www.acmicpc.net/problem/5430
public class P5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        // 테스트 케이스의 개수
        int T = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < T; i++) {
            // 수행할 함수
            String[] functions = bufferedReader.readLine().split("");
            // 배열에 들어있는 수의 개수
            int n = Integer.parseInt(bufferedReader.readLine());
            // [x1,...,xn]과 같은 형태로 배열에 들어있는 정수
            String str = bufferedReader.readLine();
            String[] numbers = str.substring(1, str.length() - 1).split(",");
            Deque<String> deque = new LinkedList<>();
            if (!numbers[0].isEmpty()) {
                for (String number : numbers) {
                    deque.offer(number);
                }
            }
            // 입력으로 주어진 정수 배열에 함수를 수행한 결과
            boolean isError = false;
            boolean isFlip = false;
            Root:
            for (String function : functions) {
                switch (function) {
                    // R은 배열에 있는 수의 순서를 뒤집는 함수
                    case "R":
                        isFlip = !isFlip;
                        break;
                    // D는 첫 번째 수를 버리는 함수
                    case "D":
                        if (deque.isEmpty()) {
                            isError = true;
                            break Root;
                        }
                        if (isFlip) {
                            deque.pollLast();
                        } else {
                            deque.pollFirst();
                        }
                        break;
                }
            }
            // 에러가 발생한 경우에는 error를 출력
            if (isError) {
                bufferedWriter.write("error");
            } else {
                bufferedWriter.write("[");
                while (deque.size() > 1) {
                    bufferedWriter.write(isFlip ? deque.pollLast() : deque.pollFirst());
                    bufferedWriter.write(",");
                }
                if (!deque.isEmpty()) {
                    bufferedWriter.write(deque.poll());
                }
                bufferedWriter.write("]");
            }
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
