package programmers.lv1;

import java.util.Arrays;

public class P131705_삼총사 {

    static boolean[] isVisited;
    static int answer;

    public static void main(String[] args) {
        System.out.println(solution(new int[]{-2, 3, 0, 2, -5}));
        System.out.println(solution(new int[]{-3, -2, -1, 0, 1, 2, 3}));
        System.out.print(solution(new int[]{-1, 1, -1, 1}));
    }

    public static int solution(int[] number) {
        answer = 0;
        isVisited = new boolean[number.length];

        for (int i = 0; i < number.length; i++) {
            DFS(number, i, 1, number[i]);

            Arrays.fill(isVisited, false);
        }

        return answer;
    }

    public static void DFS(int[] number, int v, int depth, int sum) {
        isVisited[v] = true;

        if (depth == 3) {
            if (sum == 0) {
                answer++;
            }

            isVisited[v] = false;

            return;
        }

        for (int i = v + 1; i < number.length; i++) {
            if (!isVisited[i]) {
                DFS(number, i, depth + 1, sum + number[i]);
            }
        }
    }

}
