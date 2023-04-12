package com.github.mosinpower;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Дан массив из нулей и единиц. Нужно определить, какой максимальный по длине подинтервал единиц можно получить, удалив ровно один элемент массива.
 *
 * [1, 1, 0]
 */
public class SubIntervalTest {


    private int maxLenOf1WithOneDeletion(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int prev = nums[0];
        boolean hasZeros = false;
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            if(prev == 0 && cur == 0) {
                list.add(prev);
                hasZeros = true;
            } else if(prev == 0 && cur == 1) {
                list.add(prev);
                prev = cur;
                hasZeros = true;
            } else if(prev != 0 && cur == 1) {
                prev++;
            } else if(prev != 0 && cur == 0) {
                list.add(prev);
                prev = cur;
                hasZeros = true;
            }
        }
        list.add(prev);

        List<Integer> maxLengths = new ArrayList<>();
        for(int i = 0; i < list.size(); i++) {
            int cur1 = list.get(i);
            int cur2 = 0;
            if(i + 1 < list.size()) {
                cur2 = list.get(i + 1);
            }
            int cur3 = 0;
            if(i + 2 < list.size()) {
                cur3 = list.get(i + 2);
            }
            maxLengths.add(cur1 + cur2 + cur3);
        }

        return Collections.max(maxLengths) - (hasZeros? 0 : 1);
    }


    @Test
    void test2() {
        int[] arr1 = {1, 1, 0};
        int expected = 2;

        int actual = maxLenOf1WithOneDeletion(arr1);
        assertEquals(expected, actual);
    }

    @Test
    void test1() {
        int[] arr1 = {1, 1, 0, 1, 1, 1, 0, 1, 1};;
        int expected = 5;

        int actual = maxLenOf1WithOneDeletion(arr1);
        assertEquals(expected, actual);
    }
}
