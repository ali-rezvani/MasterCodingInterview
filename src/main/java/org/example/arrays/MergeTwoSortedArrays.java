package org.example.arrays;

import java.util.Arrays;

/*
    You're given two sorted arrays of integers, nums1 and nums2,
     and two integers m and n representing the number of elements in nums1 and nums2, respectively.

    You must merge nums2 into nums1 as one sorted array.

    You can assume that nums1 has enough space (size that is equal to m + n) to hold additional elements from nums2.
 */


public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
//        int[] nums1 = {4, 5, 6, 0, 0, 0};
        int[] nums2 = {2, 4, 6};
//        int[] nums2 = {1, 2, 3};

        int[] sorted = sort(nums1, nums2, 3);
        System.out.println("Sorted array: " + Arrays.toString(sorted));
    }

    private static int[] sort(int[] nums1, int[] nums2, int m) {
        int p1 = m - 1, p2 = nums2.length - 1;
        int write = m + nums2.length - 1;
        while (p2 >= 0 && p1 >= 0) {
            if (nums1[p1] < nums2[p2]) {
                nums1[write--] = nums2[p2--];
            } else {
                nums1[write--] = nums1[p1--];
            }
        }

        while (p2 > -1) {
            nums1[p2] = nums2[p2--];
        }
        return nums1.clone();
    }

}
