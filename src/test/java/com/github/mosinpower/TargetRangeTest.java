package com.github.mosinpower;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Дан список интов и число-цель. Нужно найти такой range, чтобы сумма его элементов давала число-цель.
 * <p>
 * elements = [1, -3, 4, 5]
 * <p>
 * target = 9
 * <p>
 * result = range(2, 4) # because elements[2] + elements[3] == target
 *
 */
public class TargetRangeTest {

    class PairAndSum {
        int left;
        int right;
        int val;
        public PairAndSum(int left, int right, int val) {
            this.left = left;
            this.right = right;
            this.val = val;
        }
    }

    private int[] getTargetRange(int[] arr1, int target) {
        if (arr1.length == 1) {
            if (arr1[0] != target) {
                throw new RuntimeException("No target");
            } else {
                return new int[]{0, 0};
            }
        }

        List<PairAndSum> src = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] == target) {
                return new int[]{i, i};
            }
            src.add(new PairAndSum(i, i, arr1[i]));
        }

        List<PairAndSum> prev = src;
        ArrayList<PairAndSum> list = new ArrayList<>();
        int mover = 0;
        while (prev.size() > 1) {
            for (int i = 1; i < prev.size(); i++) {
                PairAndSum elem = prev.get(i - 1);
                int left = elem.left;
                int right = elem.right + 1;
                int val = elem.val + arr1[i + mover];
                if(val == target) {
                    return new int[]{left, right};
                }
                list.add(new PairAndSum(left, right, val));
            }
            prev = list;
            list = new ArrayList<>();
            mover++;
        }

        throw new RuntimeException("No target");
    }

    @Test
    public void test1(){
        int[] input = new int[]{1, -3, 4, 5};
        int target = 9;
        int[] expected = new int[]{2,3};

        int[] targetRange = getTargetRange(input, target);

        Assertions.assertArrayEquals(expected, targetRange);

    }

    @Test
    public void test2(){
        int[] input = new int[]{9};
        int target = 9;
        int[] expected = new int[]{0,0};

        int[] targetRange = getTargetRange(input, target);

        Assertions.assertArrayEquals(expected, targetRange);

    }

    @Test
    public void test3(){
        int[] input = new int[]{1,8};
        int target = 9;
        int[] expected = new int[]{0,1};

        int[] targetRange = getTargetRange(input, target);

        Assertions.assertArrayEquals(expected, targetRange);

    }

    @Test
    public void test4(){
        int[] input = new int[]{1,2,3,4};
        int target = 10;
        int[] expected = new int[]{0,3};

        int[] targetRange = getTargetRange(input, target);

        Assertions.assertArrayEquals(expected, targetRange);

    }

    @Test
    public void test5(){
        int[] input = new int[]{1,2,3,4,0};
        int target = 7;
        int[] expected = new int[]{2,3};

        int[] targetRange = getTargetRange(input, target);

        Assertions.assertArrayEquals(expected, targetRange);

    }


}
