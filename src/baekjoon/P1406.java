package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

// https://www.acmicpc.net/problem/1406
public class P1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // 초기에 편집기에 입력되어 있는 문자열
        String[] alphabets = bufferedReader.readLine().split("");
        List<String> list = new LinkedList<>();
        Collections.addAll(list, alphabets);
        // 커서
        ListIterator<String> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            listIterator.next();
        }
        // 입력할 명령어의 개수
        int M = Integer.parseInt(bufferedReader.readLine());
        // 모든 명령어를 수행
        for (int i = 0; i < M; i++) {
            String[] orders = bufferedReader.readLine().split(" ");
            switch (orders[0]) {
                // 커서를 왼쪽으로 한 칸 옮김 (커서가 문장의 맨 앞이면 무시됨)
                case "L":
                    if (listIterator.hasPrevious()) {
                        listIterator.previous();
                    }
                    break;
                // 커서를 오른쪽으로 한 칸 옮김 (커서가 문장의 맨 뒤이면 무시됨)
                case "D":
                    if (listIterator.hasNext()) {
                        listIterator.next();
                    }
                    break;
                // 커서 왼쪽에 있는 문자를 삭제함 (커서가 문장의 맨 앞이면 무시됨)
                // 삭제로 인해 커서는 한 칸 왼쪽으로 이동한 것처럼 나타나지만, 실제로 커서의 오른쪽에 있던 문자는 그대로임
                case "B":
                    if (listIterator.hasPrevious()) {
                        listIterator.previous();
                        listIterator.remove();
                    }
                    break;
                // $라는 문자를 커서 왼쪽에 추가함
                case "P":
                    listIterator.add(orders[1]);
                    break;
            }
        }
        System.out.print(String.join("", list));
    }
}
