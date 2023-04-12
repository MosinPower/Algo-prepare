package com.github.mosinpower;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *  Rotate Array
 *  Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 */
public class RotateArrayTest {


    public void rotate(int[] nums, int k) {
        int steps = k % nums.length;
        int[] copy = new int[nums.length];

        System.arraycopy(nums, 0, copy, 0, nums.length);

        for (int i = 0; i < copy.length; i++) {
            int elem = copy[i];
            int setIndex = (i + steps) % copy.length;
            nums[setIndex] = elem;
        }

    }


    /**
     * Input: nums = [1,2,3,4,5,6,7], k = 3
     * Output: [5,6,7,1,2,3,4]
     * Explanation:
     * rotate 1 steps to the right: [7,1,2,3,4,5,6]
     * rotate 2 steps to the right: [6,7,1,2,3,4,5]
     * rotate 3 steps to the right: [5,6,7,1,2,3,4]

     * rotate 4 steps to the right: [5,6,7,1,2,3,4]
     * rotate 5 steps to the right: [4,5,6,7,1,2,3]
     * rotate 6 steps to the right: [3,4,5,6,7,1,2]
     * rotate 7 steps to the right: [2,3,4,5,6,7,1]
     * rotate 8 steps to the right: [1,2,3,4,5,6,7]
     */
    @Test
    public void test1(){
        int[] nums = new int[]{1,2,3,4,5,6,7};
        int k = 3;

        int[] expected = new int[]{5,6,7,1,2,3,4};
        rotate(nums, k);

        Assertions.assertArrayEquals(expected, nums);
    }

    /**
     * Input: nums = [-1,-100,3,99], k = 2
     * Output: [3,99,-1,-100]
     * Explanation:
     * rotate 1 steps to the right: [99,-1,-100,3]
     * rotate 2 steps to the right: [3,99,-1,-100]
     */
    @Test
    public void test2(){
        int[] nums = new int[]{-1,-100,3,99};
        int k = 2;
        int[] expected = new int[]{3,99,-1,-100};

        rotate(nums, k);
        Assertions.assertArrayEquals(expected, nums);
    }

}
