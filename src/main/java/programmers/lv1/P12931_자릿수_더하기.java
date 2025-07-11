package programmers.lv1;

public class P12931_자릿수_더하기 {

    public static void main(String[] args) {
        System.out.println(solution(123));
        System.out.print(solution(987));
    }

    public static int solution(int n) {
        return String.valueOf(n).chars()
                .map(Character::getNumericValue)
                .sum();
    }

}
