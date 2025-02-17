package org.example.integers;

import java.util.HashSet;
import java.util.Set;

public class SingleNumber {

    public static void main(String[] args) {
        int[] numbers = new int[]{2,1,5,2,1,3,5,3};
        bruteSolution1(numbers);
        xorSolution2(numbers);
    }

    private static void xorSolution2(int[] numbers) {
        int number = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            number=number^numbers[i];
        }
        System.out.println(number);
    }

    private static void bruteSolution1(int[] numbers) {
        Set<Integer> set = new HashSet();
        for (int number : numbers) {
            if (set.contains(number)) {
                set.remove(number);
                continue;
            }
            set.add(number);
        }

        set.forEach(System.out::println);
    }
}
