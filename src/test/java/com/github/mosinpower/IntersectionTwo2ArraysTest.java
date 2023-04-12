package com.github.mosinpower;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * Intersection of Two Arrays II
 * Given two integer arrays nums1 and nums2, return an array of their intersection.
 * Each element in the result must appear as many times as it shows in both arrays,
 * and you may return the result in any order.
 */
public class IntersectionTwo2ArraysTest {

    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> numAndCounter = new HashMap<>();
        for(Integer num : nums1) {
            Integer counter = numAndCounter.getOrDefault(num, 0);
            numAndCounter.put(num, counter + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (Integer num: nums2){
            Integer counter = numAndCounter.getOrDefault(num, 0);
            if(counter > 0) {
                list.add(num);
                numAndCounter.put(num, counter - 1);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }


    /**
     * Input: nums1 = [1,2,2,1], nums2 = [2,2]
     * Output: [2,2]
     */
    @Test
    public void test1(){
        int[] nums1 = new int[]{1,2,2,1};
        int[] nums2 = new int[]{2,2};

        int[] expected = new int[]{2,2};
        int[] actual = intersect(nums1, nums2);
        Arrays.sort(expected);
        Arrays.sort(actual);
        Assertions.assertArrayEquals(expected, actual);
    }

    /**
     * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * Output: [4,9]
     * Explanation: [9,4] is also accepted.
     */
    @Test
    public void test2(){
        int[] nums1 = new int[]{4,9,5};
        int[] nums2 = new int[]{9,4,9,8,4};

        int[] expected = new int[]{9,4};
        int[] actual = intersect(nums1, nums2);
        Arrays.sort(expected);
        Arrays.sort(actual);
        Assertions.assertArrayEquals(expected, actual);
    }


}
