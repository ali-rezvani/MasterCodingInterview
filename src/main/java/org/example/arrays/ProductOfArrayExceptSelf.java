package org.example.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        var nums = new int[]{1, 2, 3, 4};
        var product = bruthForcepproductOfArrayExceptSelf(nums);
        System.out.println(Arrays.toString(product));
    }

    private static int[] bruthForcepproductOfArrayExceptSelf(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i =0;i<nums.length;i++) {
            int multiplier = 1;
            for (int j =0;j<nums.length;j++) {
                if (j != i) {
                    multiplier = multiplier*nums[j];
                }
            }
            list.add(multiplier);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    private static int[] optimalSolution(int[] nums) {
        var result = new int[nums.length];
        result[0] = 1;
//        for left side
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i-1] * nums[i];
        }

//        for right side
        var right=1;
        for (int i = nums.length; i >= 0; i--) {
            result[i] = result[i] * right;
            right=right*nums[i];
        }

        return result;
    }
}