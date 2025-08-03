package programmers.lv1;

public class P12948_핸드폰_번호_가리기 {

    public static void main(String[] args) {
        System.out.print(solution("01234012340123401234"));
    }

    public static String solution(String phone_number) {
        int length = phone_number.length();

        return "*".repeat(length - 4) + phone_number.substring(length - 4, length);
    }

}
