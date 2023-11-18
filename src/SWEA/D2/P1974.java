package SWEA.D2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class P1974 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int testCase = 1; testCase <= T; testCase++) {
            int[][] sudoku = new int[9][9];
            for (int i = 0; i < sudoku.length; i++) {
                for (int j = 0; j < sudoku[i].length; j++) {
                    sudoku[i][j] = scanner.nextInt();
                }
            }
            int answer = 1;
            // N x N Validate
            for (int i = 0; i < sudoku.length; i += 3) {
                for (int j = 0; j < sudoku[i].length; j += 3) {
                    Set<Integer> numbers = new HashSet<>();
                    for (int k = i; k < i + 3; k++) {
                        for (int l = j; l < j + 3; l++) {
                            numbers.add(sudoku[k][l]);
                        }
                    }
                    if (numbers.size() != 9) {
                        answer = 0;
                    }
                }
            }
            // Row,Col Validate
            for (int i = 0; i < sudoku.length; i++) {
                Set<Integer> rowNumbers = new HashSet<>();
                Set<Integer> colNumbers = new HashSet<>();
                for (int j = 0; j < sudoku[i].length; j++) {
                    rowNumbers.add(sudoku[i][j]);
                    colNumbers.add(sudoku[j][i]);
                }
                int size = Math.min(rowNumbers.size(), colNumbers.size());
                if (size != 9) {
                    answer = 0;
                }
            }
            System.out.printf("#%d %d\n", testCase, answer);
        }
    }
}
