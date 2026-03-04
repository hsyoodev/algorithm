package baekjoon.silver;

public class P1456_거의_소수 {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        long A = Math.max(2, scanner.nextLong());
//        long B = scanner.nextLong();
//        Set<Long> numbers = new HashSet<>();
//
//        for (long i = 2; i <= Math.sqrt(B); i++) {
//            if (isPrimeNumber(i)) {
//                for (int j = 2; Math.pow(i, j) <= B; j++) {
//                    if ((long) Math.pow(i, j) >= A && (long) Math.pow(i, j) <= B) {
//                        numbers.add((long) Math.pow(i, j));
//                    }
//                }
//            }
//        }
//
//        System.out.print(numbers.size());
    }

    private static boolean isPrimeNumber(long number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

}
