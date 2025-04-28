package org.example.arrays;

import java.util.*;

/*
 *   Challenge 1:Given an array of integers nums and an integer target,
 *       return indices of the two numbers such that they add up to the target.
 *   Challenge 2: Given an array of integers and a target sum,
 *        return all unique pairs (values, not indices) that add up to the target.
 * */
public class TowSumArray {

    public static void main(String[] args) {
        Integer[] array = new Integer[]{1, 3, 9, 7, 5, 2};
        int target = 11;
        bruteForceSearch(target, array);
        optimizedSearch(target, array);

        int[] array2 = new int[]{1, 3, 9, 7, 4, 8, 5, 2};

        var uniquePairs = allUniquePairs(array2, target);
        System.out.println(uniquePairs);
    }

    private static void bruteForceSearch(int target, Integer... array) {
        for (int i = 0; i < array.length - 1; i++) {
            var P1 = array[i];
            P1 = array[i];
            int t = target - P1;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] == t) {
                    System.out.println("Index1=" + i + " Index2=" + j + " AND P1=" + array[i] + " P2=" + array[j]);
                    return;// Exit after finding the first valid pair
                }
            }
        }

        // If no solution is found
        System.out.println("No valid indices found");
    }

    public static void optimizedSearch(int target, Integer... array) {
        Map<Integer, Integer> numIndexMap = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            int numberToFind = target - array[i];
            // Check if the needed number is already in the map
            if (numIndexMap.containsKey(numberToFind)) {
                System.out.println("Index1=" + numIndexMap.get(numberToFind) + ", Index2=" + i + " AND P1=" + array[numIndexMap.get(numberToFind)] + " P2=" + array[i]);
                return; // Exit after finding the first valid pair
            }

            // Store the current number with its index
            numIndexMap.put(array[i], i);
        }

        // If no solution is found
        System.out.println("No valid indices found");
    }


    public static List<List<Integer>> allUniquePairs(int[] nums, int target) {
        Set<Integer> seen = new HashSet<>();
        Map<Integer, Integer> usedPairs = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();

        for (int num : nums) {
            var complement = target - num;
            if (seen.contains(complement)) {
                int low = Math.min(num, complement);
                int high = Math.max(num, complement);
                if (!usedPairs.containsKey(low)) {
                    usedPairs.put(low, high);
                    result.add(Arrays.asList(low, high));
                }
            }
            seen.add(num);
        }
        return result;
    }
}
