package com.github.mosinpower;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Squares of Sorted Array
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
 */
public class SquaresofSortedArrayTest {


    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int left=0;
        int right=nums.length - 1;

        int iter = right;

        while(iter >= 0) {
            int leftElem = nums[left] * nums[left];
            int rightElem = nums[right] * nums[right];
            if(leftElem > rightElem) {
                res[iter] = leftElem ;
                left++;
            } else {
                res[iter] = rightElem;
                right--;
            }
            iter--;
        }
        return res;
    }

    @Test
    public void test1(){
        int[] nums = new int[]{-4,-1,0,3,10};
        int[] expected = new int[]{0,1,9,16,100};
        int[] actual = sortedSquares(nums);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test2(){
        int[] nums = new int[]{-4,-1,0,3,10};
        int[] expected = new int[]{0,1,9,16,100};
        int[] actual = sortedSquares(nums);
        Assertions.assertArrayEquals(expected, actual);
    }


}
