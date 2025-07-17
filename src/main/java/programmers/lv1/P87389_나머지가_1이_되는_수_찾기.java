package programmers.lv1;

public class P87389_나머지가_1이_되는_수_찾기 {

    public static void main(String[] args) {
        System.out.print(solution(10));
    }

    public static int solution(int n) {
        int answer = 2;

        for (int i = 2; i < n; i++) {
            if (n % i == 1) {
                answer = i;

                break;
            }
        }

        return answer;
    }

}
