package com.github.mosinpower;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Даны два массива: [1, 2, 3, 2, 0] и [5, 1, 2, 7, 3, 2]
 * Надо вернуть [1, 2, 2, 3] (порядок неважен)
 */
class InterceptionTest {


    public int[] intercept(int[] arr1, int[] arr2) {

        Map<Integer, Integer> numAndCount1 = new HashMap<>();
        for (int elem1 : arr1) {
            Integer count = numAndCount1.getOrDefault(elem1, 0);
            numAndCount1.put(elem1, count + 1);
        }

        List<Integer> res = new ArrayList<>();
        for (int elem2 : arr2) {
            if (numAndCount1.containsKey(elem2)) {
                Integer count = numAndCount1.get(elem2);
                if (count > 0) {
                    res.add(elem2);
                    numAndCount1.put(elem2, count - 1);
                }
            }
        }


        System.out.println(res);
        return res.stream().mapToInt(i -> i).toArray();
    }

    @Test
    void fromDescription() {
        int[] arr1 = {1,2,3,2,0};
        int[] arr2 = {5, 1, 2, 7, 3, 2};
        int[] expected = {1,2,2,3};

        int[] actual = intercept(arr1, arr2);

        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }
}