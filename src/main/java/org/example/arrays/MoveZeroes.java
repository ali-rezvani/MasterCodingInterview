package org.example.arrays;

import java.util.Arrays;

/*
    Given an integer array nums, move all 0's to the end of it while maintaining
    the relative order of the non-zero elements.

    You must do this in-place without making a copy of the array,
     and minimize the total number of operations.
* */
public class MoveZeroes {

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,0,1, 1, 0, 3, 12};
        int[] movedArray=moveZeros(nums);
        System.out.println(Arrays.toString(movedArray));
    }

    private static int[] moveZeros(int[] nums) {
        int p=0,zeroCounter=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                zeroCounter++;
            }else {
                nums[p++]=nums[i];
            }
        }
        for (int i=nums.length-zeroCounter;i<nums.length;i++){
            nums[i]=0;
        }
        return nums.clone();
    }
}
