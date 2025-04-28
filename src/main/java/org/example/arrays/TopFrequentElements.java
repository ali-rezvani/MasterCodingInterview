package org.example.arrays;
/*
    Given an integer array nums and an integer k, return the k most frequent elements.
*/

import java.util.*;

public class TopFrequentElements {

    public static void main(String[] args) {
        var array = new int[]{4, 1, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 5};
        var k=3;

        var topFrequentElements = findTopFrequentElements(array,k);
        System.out.println(Arrays.toString(topFrequentElements));
    }

    private static int[] findTopFrequentElements(int[] array, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i :array) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            }else {
                map.put(i, 1);
            }
        }

        PriorityQueue<Map.Entry<Integer, Integer>> heap =
                new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            heap.offer(entry);
            if (heap.size() > k) {
                heap.poll(); // Remove least frequent element
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!heap.isEmpty()) {
            result.add(heap.poll().getKey());
        }
        Collections.reverse(result);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
