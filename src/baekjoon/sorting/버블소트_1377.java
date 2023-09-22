package baekjoon.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 버블소트_1377 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Element[] elements = new Element[N];
        for (int i = 0; i < N; i++) {
            elements[i] = new Element(Integer.parseInt(br.readLine()), i);
        }
        Arrays.sort(elements);
        int max = 0;
        for (int i = 0; i < N; i++) {
            int diff = elements[i].index - i;
            if (max < diff) {
                max = diff;
            }
        }
        System.out.print(max + 1);
    }
}

class Element implements Comparable<Element> {
    public int value;
    public int index;

    public Element(int value, int index) {
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(Element e) {
        return this.value - e.value;
    }
}
