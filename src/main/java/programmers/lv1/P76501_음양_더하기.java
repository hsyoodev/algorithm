package programmers.lv1;

public class P76501_음양_더하기 {

    public static void main(String[] args) {
        System.out.print(solution(new int[]{4, 7, 12}, new boolean[]{true, false, true}));
    }

    public static int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

        for (int i = 0; i < absolutes.length; i++) {
            answer += absolutes[i] * (signs[i] ? 1 : -1);
        }

        return answer;
    }

}
