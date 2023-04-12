package com.github.mosinpower;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Reverse Integer
 * Given a signed 32-bit integer x, return x with its digits reversed.
 * If reversing x causes the value to go outside the signed 32-bit integer range [-2^31, 2^31 - 1], then return 0.
 * <p>
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 */
public class ReverseIntTest {


    public int reverse(int x) {
        int res = 0;
        while(x != 0) {
            int temp = res * 10 + x % 10;
            if((temp - x % 10) / 10 != res) {
                return 0;
            }
            res = temp;
            x = x / 10;
        }
        return res;
    }

    @Test
    public void test1(){
        int x = 123;
        int expected = 321;
        int actual = reverse(x);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test2(){
        int x = -123;
        int expected = -321;
        int actual = reverse(x);
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void test3(){
        int x = 120;
        int expected = 21;
        int actual = reverse(x);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test4(){
        int x = 2147483647;
        int expected = 0;
        int actual = reverse(x);
        Assertions.assertEquals(expected, actual);
    }
}
