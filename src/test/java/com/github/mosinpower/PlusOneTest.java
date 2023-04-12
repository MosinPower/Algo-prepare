package com.github.mosinpower;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Plus One
 * You are given a large integer represented as an integer array digits,
 * where each digits[i] is the ith digit of the integer. The digits are ordered from most significant
 * to least significant in left-to-right order. The large integer does not contain any leading 0's.
 * Increment the large integer by one and return the resulting array of digits.
 */
public class PlusOneTest {

    public int[] plusOne(int[] digits) {
        boolean lastNine = digits[digits.length - 1] == 9;

        if(!lastNine) {
            int[] copy = new int[digits.length];
            System.arraycopy(digits, 0, copy, 0, copy.length);
            copy[digits.length - 1] = copy[digits.length - 1] + 1;
            return copy;
        }

        int[] copy = new int[digits.length];
        System.arraycopy(digits, 0, copy, 0, copy.length);
        int ninesCount = 0;
        for (int i = copy.length - 1; i >= 0; i--) {
            if(copy[i] == 9){
                ninesCount++;
                copy[i] = 0;
            } else {
                break;
            }
        }
        if(ninesCount == digits.length) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            return res;
        } else {
            copy[digits.length - ninesCount - 1] = copy[digits.length - ninesCount - 1] + 1 ;
            return copy;
        }

    }


    /**
     * Input: digits = [1,2,3]
     * Output: [1,2,4]
     * Explanation: The array represents the integer 123.
     * Incrementing by one gives 123 + 1 = 124.
     * Thus, the result should be [1,2,4].
     */
    @Test
    public void test1(){
        int[] digits = new int[]{1,2,3};
        int[] expected = new int[]{1,2,4};

        int[] actual = plusOne(digits);
        Assertions.assertArrayEquals(expected, actual);
    }

    /**
     * Input: digits = [4,3,2,1]
     * Output: [4,3,2,2]
     * Explanation: The array represents the integer 4321.
     * Incrementing by one gives 4321 + 1 = 4322.
     * Thus, the result should be [4,3,2,2].
     */
    @Test
    public void test2(){
        int[] digits = new int[]{4,3,2,1};
        int[] expected = new int[]{4,3,2,2};

        int[] actual = plusOne(digits);
        Assertions.assertArrayEquals(expected, actual);
    }
    /**
     * Input: digits = [9]
     * Output: [1,0]
     * Explanation: The array represents the integer 9.
     * Incrementing by one gives 9 + 1 = 10.
     * Thus, the result should be [1,0].
     */
    @Test
    public void test3(){
        int[] digits = new int[]{9};
        int[] expected = new int[]{1,0};

        int[] actual = plusOne(digits);
        Assertions.assertArrayEquals(expected, actual);
    }


}
