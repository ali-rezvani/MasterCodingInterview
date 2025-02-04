package org.example.arrays;

import java.util.HashMap;
import java.util.Map;

public class TowSumArray {

    public static void main(String[] args) {
        Integer[] array = new Integer[]{1,3,9,7,5,2};
        int target = 11;
        bruteForceSearch(target,array);
        optimizedSearch(target,array);
    }

    private static void bruteForceSearch(int target, Integer...array){
        for (int i = 0; i < array.length-1; i++) {
           var P1 = array[i];
            P1=array[i];
            int t=target-P1;
            for(int j=i+1;j<array.length;j++){
                if (array[j]==t){
                    System.out.println("Index1="+i+" Index2="+j+ " AND P1="+array[i]+" P2="+array[j]);
                    return;// Exit after finding the first valid pair
                }
            }
        }

        // If no solution is found
        System.out.println("No valid indices found");
    }

    public static void optimizedSearch(int target,Integer...array) {
        Map<Integer, Integer> numIndexMap = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            int numberToFind = target - array[i];
            // Check if the needed number is already in the map
            if (numIndexMap.containsKey(numberToFind)) {
                System.out.println("Index1=" + numIndexMap.get(numberToFind) + ", Index2=" + i+" AND P1="+array[numIndexMap.get(numberToFind)]+" P2="+array[i]);
                return; // Exit after finding the first valid pair
            }

            // Store the current number with its index
            numIndexMap.put(array[i], i);
        }

        // If no solution is found
        System.out.println("No valid indices found");
    }


}
