package com.github.mosinpower;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * Move Zeroes
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * Note that you must do this in-place without making a copy of the array.
 */
public class MoveZeroesTest {

    public void moveZeroes(int[] nums) {

        int zeros = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if(cur == 0) {
                zeros++;
            } else {
                if(zeros > 0) {
                    nums[i - zeros] = cur;
                    nums[i] = 0;
                }
            }
        }

    }

    /**
     * Input: nums = [0,1,0,3,12]
     * Output: [1,3,12,0,0]
     */
    @Test
    public void test1(){
        int[] digits = new int[]{0,1,0,3,12};
        int[] expected = new int[]{1,3,12,0,0};

        moveZeroes(digits);
        System.out.println(Arrays.toString(digits));
        Assertions.assertArrayEquals(expected, digits);
    }

    /**
     * Input: nums = [0]
     * Output: [0]
     */
    @Test
    public void test2(){
        int[] digits = new int[]{0};
        int[] expected = new int[]{0};

        moveZeroes(digits);
        Assertions.assertArrayEquals(expected, digits);
    }



}
