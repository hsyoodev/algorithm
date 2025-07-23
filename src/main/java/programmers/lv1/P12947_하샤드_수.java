package programmers.lv1;

public class P12947_하샤드_수 {

    public static void main(String[] args) {
        System.out.print(solution(10));
    }

    public static boolean solution(int x) {
        return (x % String.valueOf(x).chars().map(Character::getNumericValue).sum()) == 0;
    }
    
}
