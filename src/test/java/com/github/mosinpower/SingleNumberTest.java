package com.github.mosinpower;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

/**
 * Single Number
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 */
public class SingleNumberTest {

    public int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        return set.stream().findAny().orElseThrow();
    }


    /**
     * Input: nums = [2,2,1]
     * Output: 1
     */
    @Test
    public void test1(){
        int[] nums = new int[]{2,2,1};
        int expected = 1;
        int actual = singleNumber(nums);
        Assertions.assertEquals(expected, actual);
    }

    /**
     * Input: nums = [4,1,2,1,2]
     * Output: 4
     */
    @Test
    public void test2(){
        int[] nums = new int[]{4,1,2,1,2};
        int expected = 4;
        int actual = singleNumber(nums);
        Assertions.assertEquals(expected, actual);
    }

    /**
     * Input: nums = [1]
     * Output: 1
     */
    @Test
    public void test3(){
        int[] nums = new int[]{1};
        int expected = 1;
        int actual = singleNumber(nums);
        Assertions.assertEquals(expected, actual);
    }
}
