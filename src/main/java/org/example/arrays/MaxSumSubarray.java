package org.example.arrays;

import java.util.Arrays;

/*
    Given an integer array nums, find the contiguous subarray (containing at least one number)
     which has the largest sum, and return that sum.

    Example:
    Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
    Output: 6
    Explanation: [4, -1, 2, 1] has the largest sum = 6.
* */
public class MaxSumSubarray {
    public static void main(String[] args) {
        var nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};

        var maxSum = bruteForceMaxSubArray(nums);
        System.out.println(maxSum);

        maxSum = kadaneMaxSubArray(nums);
        System.out.println(maxSum);
    }

    private static int bruteForceMaxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int currentSum = 0;
            for (int j = i; j < nums.length; j++) {
                currentSum += nums[j];
                maxSum = Math.max(maxSum, currentSum);
            }
        }
        return maxSum;
    }

    private static int kadaneMaxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    /*A little tougher version:
    Maximum Sum Subarray with indices

     Not only find the maximum sum, but also return the
     starting and ending indices of that subarray.*/

    private static int[] kadaneWithIndices(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];
        int start = 0;
        int bestStart = 0;
        int bestEnd = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > currentSum + nums[i]) {
                currentSum = nums[i];
                start = i;
            } else {
                currentSum += nums[i];
            }

            if (currentSum > maxSum) {
                maxSum = currentSum;
                bestStart = start;
                bestEnd = i;
            }
        }

        return new int[]{maxSum, bestStart, bestEnd};
    }

}
