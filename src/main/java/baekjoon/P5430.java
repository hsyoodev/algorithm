package baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// https://www.acmicpc.net/problem/5430
public class P5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        // 테스트 케이스의 개수
        int T = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < T; i++) {
            // 수행할 함수
            String p = bufferedReader.readLine();
            // 배열에 들어있는 수의 개수
            int n = Integer.parseInt(bufferedReader.readLine());
            // [x1,...,xn]과 같은 형태로 배열에 들어있는 정수
            String[] x1xn = bufferedReader.readLine().replaceAll("[\\[-\\]]", "").split(",");
            LinkedList<String> linkedList = Stream.of(x1xn).collect(Collectors.toCollection(LinkedList::new));
            boolean isFlip = false;
            boolean isError = false;
            for (int j = 0; j < p.length(); j++) {
                // R은 배열에 있는 수의 순서를 뒤집는 함수
                if (p.charAt(j) == 'R') {
                    isFlip = !isFlip;
                }
                // D는 첫 번째 수를 버리는 함수
                else {
                    // 배열이 비어있는데 D를 사용한 경우에는 에러가 발생
                    if (linkedList.isEmpty() || n == 0) {
                        isError = true;
                        break;
                    } else {
                        if (isFlip) {
                            linkedList.removeLast();
                        } else {
                            linkedList.removeFirst();
                        }
                    }
                }
            }
            // 만약, 에러가 발생한 경우에는 error를 출력한다.
            if (isError) {
                bufferedWriter.write("error");
            }
            // 입력으로 주어진 정수 배열에 함수를 수행한 결과를 출력한다.
            else {
                bufferedWriter.write("[");
                while (linkedList.size() > 1) {
                    if (isFlip) {
                        bufferedWriter.write(linkedList.removeLast() + ",");
                    } else {
                        bufferedWriter.write(linkedList.removeFirst() + ",");
                    }
                }
                if (linkedList.size() == 1) {
                    bufferedWriter.write(linkedList.remove());
                }
                bufferedWriter.write("]");
            }
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
