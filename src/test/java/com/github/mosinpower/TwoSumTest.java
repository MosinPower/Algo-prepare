package com.github.mosinpower;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * Two Sum
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 */
public class TwoSumTest {


    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> numAndIntex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int elem = nums[i];
            if(numAndIntex.containsKey(target - elem)){
                return new int[] {
                        numAndIntex.get(target - elem),
                        i
                };
            }
            numAndIntex.put(elem, i);
        }
        return new int[]{-1, -1};

    }


    @Test
    public void test1(){
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        int[] expected = new int[]{0,1};
        int[] actual = twoSum(nums, target);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test2(){
        int[] nums = new int[]{3,2,4};
        int target = 6;
        int[] expected = new int[]{1,2};
        int[] actual = twoSum(nums, target);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void test3(){
        int[] nums = new int[]{3,3};
        int target = 6;
        int[] expected = new int[]{0,1};
        int[] actual = twoSum(nums, target);
        Assertions.assertArrayEquals(expected, actual);
    }
}
