package com.github.mosinpower;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

/**
 * Contains Duplicate
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 */
public class ContainsDuplicatesTest {

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }

        return false;

    }


    /**
     * Input: nums = [1,2,3,1]
     * Output: true
     */
    @Test
    public void test1(){
        int[] nums = new int[]{1,2,3,1};
        Assertions.assertTrue(containsDuplicate(nums));
    }

    /**
     * Input: nums = [1,2,3,4]
     * Output: false
     */
    @Test
    public void test2(){
        int[] nums = new int[]{1,2,3,4};
        Assertions.assertFalse(containsDuplicate(nums));
    }

    /**
     * Input: nums = [1,1,1,3,3,4,3,2,4,2]
     * Output: true
     */
    @Test
    public void test3(){
        int[] nums = new int[]{1,1,1,3,3,4,3,2,4,2};
        Assertions.assertTrue(containsDuplicate(nums));
    }
}
