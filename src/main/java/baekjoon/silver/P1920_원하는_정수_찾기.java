package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1920_원하는_정수_찾기 {

    private static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        numbers = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            binarySearch(Integer.parseInt(st.nextToken()));
        }

        br.close();
    }

    private static void binarySearch(int targetNumber) {
        int startIndex = 0;
        int endIndex = numbers.length - 1;
        boolean isExist = false;

        while (startIndex <= endIndex) {
            int middleIndex = (startIndex + endIndex) / 2;
            int middleNumber = numbers[middleIndex];

            if (middleNumber > targetNumber) {
                endIndex = middleIndex - 1;
            } else if (middleNumber < targetNumber) {
                startIndex = middleIndex + 1;
            } else {
                isExist = true;

                break;
            }
        }

        System.out.println(isExist ? 1 : 0);
    }

}
