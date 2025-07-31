package programmers.lv1;

public class P12943_콜라츠_추측 {

    public static void main(String[] args) {
        System.out.print(solution(626331));
    }

    public static int solution(long num) {
        int answer = 0;

        while (num != 1) {
            if (answer == 500) {
                return -1;
            }

            num = (num % 2 == 0) ? (num / 2) : (num * 3 + 1);

            answer++;
        }

        return answer;
    }

}
