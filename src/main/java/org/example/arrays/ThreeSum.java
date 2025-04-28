package org.example.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
*   Given an integer array nums,
*       Return all unique triplets [nums[i], nums[j], nums[k]] such that:

*       i != j, i != k, and j != k

*       nums[i] + nums[j] + nums[k] == 0

*       Triplets must be unique, regardless of order.
*
*   Next Steps: 1- Try the variation with a custom target (not necessarily 0)
*               2- Extend to 4Sum
*/
public class ThreeSum {

    public static void main(String[] args) {
        var array=new int[]{-1, 0, 1, 2, -1, -4,4};
        var result=threeSum(array);
        System.out.println(result);
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (var i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // skip duplicates

            var left = i + 1;
            var right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // skip duplicates
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++; // move to higher values
                } else {
                    right--; // move to smaller values
                }
            }
        }

        return result;
    }

}
