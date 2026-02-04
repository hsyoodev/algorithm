import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {

    private static int[] lectureLengths;
    private static int M;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lectureLengths = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            lectureLengths[i] = Integer.parseInt(st.nextToken());
        }

        int sum = IntStream.of(lectureLengths).sum();
        int max = IntStream.of(lectureLengths).max().getAsInt();
        answer = sum;

        binarySearch(max, sum);

        System.out.print(answer);
    }

    private static void binarySearch(int start, int end) {
        if (start > end) {
            return;
        }

        int middle = (start + end) / 2;
        int sum = 0;
        int count = 0;

        for (int lectureLength : lectureLengths) {
            if (sum + lectureLength > middle) {
                sum = 0;
                count++;
            }

            sum += lectureLength;
        }

        if (sum != 0) {
            count++;
        }

        if (count <= M) {
            answer = Math.min(answer, middle);

            binarySearch(start, middle - 1);
        } else {
            binarySearch(middle + 1, end);
        }
    }

}
