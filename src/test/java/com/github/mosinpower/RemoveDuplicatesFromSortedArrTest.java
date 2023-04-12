package com.github.mosinpower;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * Given an integer array nums sorted in non-decreasing order,
 * remove the duplicates in-place such that each unique element appears only once.
 * The relative order of the elements should be kept the same.
 * Then return the number of unique elements in nums.
 */
public class RemoveDuplicatesFromSortedArrTest {

    public int removeDuplicates(int[] nums) {
        int prev = nums[0];
        int count = 1;
        int pointer = 0;
        for (int i = 1; i < nums.length; i++) {
            if(prev != nums[i]) {
                count++;
                prev = nums[i];
                pointer++;
                nums[pointer] = nums[i];
            }
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(count);
        return count;
    }


    /**
     * Input: nums = [0,0,1,1,1,2,2,3,3,4]
     * Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
     * Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
     * It does not matter what you leave beyond the returned k (hence they are underscores).
     */
    @Test
    public void test1(){
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        int actual = removeDuplicates(nums);

        Assertions.assertEquals(5, actual);

    }
    @Test
    public void test2(){
        int[] nums = new int[]{1,1,2};
        int actual = removeDuplicates(nums);

        Assertions.assertEquals(2, actual);

    }

}
