package com.github.mosinpower;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Дан список интов и число-цель. Нужно найти такой range, чтобы сумма его элементов давала число-цель.
 * <p>
 * elements = [1, -3, 4, 5]
 * <p>
 * target = 9
 * <p>
 * result = range(2, 4) # because elements[2] + elements[3] == target
 */
public class TargetRangeTest {

    public static int[] getTargetRange(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[]{-1, -1};
        int sum = 0;

        map.put(0, -1);

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (map.containsKey(sum - target)) {
                result[0] = map.get(sum - target) + 1;
                result[1] = i;
                break;
            }

            map.put(sum, i);
        }

        System.out.println(Arrays.toString(result));
        return result;
    }





    @Test
    public void testBig() {
        int[] input = new int[]{1000, 500, 400, 2, 1};
        int target = 3;
        int[] expected = new int[]{3, 4};

        int[] targetRange = getTargetRange(input, target);

        Assertions.assertArrayEquals(expected, targetRange);
    }

    @Test
    public void testSum() {
        int[] input = new int[]{1, 1, 100, -10, 200, 1, 1};
        int target = 290;
        int[] expected = new int[]{2, 4};

        int[] targetRange = getTargetRange(input, target);

        Assertions.assertArrayEquals(expected, targetRange);
    }

    @Test
    public void testZero1() {
        int[] input = new int[]{1, 5, -2, 0, 4, 5};
        int target = 1;
        int[] expected = new int[]{0, 0};

        int[] targetRange = getTargetRange(input, target);

        Assertions.assertArrayEquals(expected, targetRange);
    }


    @Test
    public void testRepeatable() {
        int[] input = new int[]{4, 5, 5, 4, 4, 5, 1, 5, 4, 5, 4};
        int target = 11;
        int[] expected = new int[]{5, 7};

        int[] targetRange = getTargetRange(input, target);

        Assertions.assertArrayEquals(expected, targetRange);
    }

    @Test
    public void testZero() {
        int[] input = new int[]{-1, 5, -2, 0, 4, 5};
        int target = 6;
        int[] expected = new int[]{0, 4};

        int[] targetRange = getTargetRange(input, target);

        Assertions.assertArrayEquals(expected, targetRange);
    }

    @Test
    public void test0123() {
        int[] input = new int[]{-1, -2, 4, 5};
        int target = 9;
        int[] expected = new int[]{2, 3};

        int[] targetRange = getTargetRange(input, target);

        Assertions.assertArrayEquals(expected, targetRange);
    }

    @Test
    public void test1123() {
        int[] input = new int[]{1, -3, 4, 5};
        int target = 9;
        int[] expected = new int[]{2, 3};

        int[] targetRange = getTargetRange(input, target);

        Assertions.assertArrayEquals(expected, targetRange);
    }

    @Test
    public void hardTest() {
        int[] input = new int[]{1, -100, 4, -200, 500, 5, 4, -4, 1, 1, 1};
        int target = 211;
        int[] expected = new int[]{0, 8};

        int[] targetRange = getTargetRange(input, target);

        Assertions.assertArrayEquals(expected, targetRange);
    }

    @Test
    public void test01() {
        int[] input = new int[]{1, -100, 4, -200, 500, 5, 4, -4, 1, 1, 1};
        int target = 211;
        int[] expected = new int[]{0, 8};

        int[] targetRange = getTargetRange(input, target); //rangeof

        Assertions.assertArrayEquals(expected, targetRange);
    }

    @Test
    public void test0() {
        int[] input = new int[]{-1, -2, 4, 5};
        int target = 9;
        int[] expected = new int[]{2, 3};

        int[] targetRange = getTargetRange(input, target);

        Assertions.assertArrayEquals(expected, targetRange);

    }

    @Test
    public void test1() {
        int[] input = new int[]{1, -3, 4, 5};
        int target = 9;
        int[] expected = new int[]{2, 3};

        int[] targetRange = getTargetRange(input, target);

        Assertions.assertArrayEquals(expected, targetRange);

    }


    @Test
    public void test2() {
        int[] input = new int[]{9};
        int target = 9;
        int[] expected = new int[]{0, 0};

        int[] targetRange = getTargetRange(input, target);

        Assertions.assertArrayEquals(expected, targetRange);

    }

    @Test
    public void test3() {
        int[] input = new int[]{1, 8};
        int target = 9;
        int[] expected = new int[]{0, 1};

        int[] targetRange = getTargetRange(input, target);

        Assertions.assertArrayEquals(expected, targetRange);

    }

    @Test
    public void test4() {
        int[] input = new int[]{1, 2, 3, 4};
        int target = 10;
        int[] expected = new int[]{0, 3};

        int[] targetRange = getTargetRange(input, target);

        Assertions.assertArrayEquals(expected, targetRange);

    }


    @Test
    public void test5() {
        int[] input = new int[]{1, 2, 3, 4, 0};
        int target = 7;
        int[] expected = new int[]{2, 3};

        int[] targetRange = getTargetRange(input, target);

        Assertions.assertArrayEquals(expected, targetRange);

    }

    @Test
    public void test6() {
        int[] input = new int[]{1, -7, 2, 9, 3, 4};

        int target = 12;
        int[] expected = new int[]{3, 4};

        int[] targetRange = getTargetRange(input, target);

        Assertions.assertArrayEquals(expected, targetRange);

    }


}
