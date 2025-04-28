package org.example.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
    Given an array of strings, how many of these strings have their reverse also present in the array?
*/
public class ReversedPairs {

    public static void main(String[] args) {
        String[] strings = {"abc", "cba", "xy", "yx", "test", "set", "tset"};
        System.out.println(countReversedPairs(strings));

    }

    public static int countReversedPairs(String[] arr) {
        Set<String> set = new HashSet<>(Arrays.asList(arr));
        Set<String> counted = new HashSet<>();
        int count = 0;

        for (String s : arr) {
            String reversed = new StringBuilder(s).reverse().toString();

            // Avoid double counting and self-reversing(palindromes) strings
            if (!counted.contains(s) && set.contains(reversed) && !s.equals(reversed)) {
                count++;
                counted.add(s);
                counted.add(reversed); // mark both as counted
            }
        }

        return count;
    }
}
