package programmers.lv1;

public class P77884_약수의_개수와_덧셈 {

    public static void main(String[] args) {
        System.out.print(solution(13, 17));
    }

    public static int solution(int left, int right) {
        int answer = 0;

        for (int i = left; i <= right; i++) {
            answer += (i % Math.sqrt(i) == 0) ? -i : i;
        }

        return answer;
    }

}
