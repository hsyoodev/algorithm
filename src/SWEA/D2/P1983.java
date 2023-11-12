package SWEA.D2;

import java.util.Arrays;
import java.util.Scanner;

public class P1983 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        String[] grades = {"D0", "C-", "C0", "C+", "B-", "B0", "B+", "A-", "A0", "A+"};
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            Student[] students = new Student[N];
            for (int i = 0; i < N; i++) {
                double midtermScore = scanner.nextInt() * 0.035;
                double finalScore = scanner.nextInt() * 0.045;
                double assignmentScore = scanner.nextInt() * 0.020;
                double score = midtermScore + finalScore + assignmentScore;
                students[i] = new Student(i + 1, score);
            }
            Arrays.sort(students);
            for (int i = 0; i < N; i++) {
                Student student = students[i];
                if (student.number == K) {
                    int grade = i / (N / 10);
                    System.out.printf("#%d %s\n", test_case, grades[grade]);
                }
            }
        }
    }
}

class Student implements Comparable<Student> {

    public int number;
    public double score;

    public Student(int number, double score) {
        this.number = number;
        this.score = score;
    }

    @Override
    public int compareTo(Student o) {
        return Double.compare(score, o.score);
    }
}
