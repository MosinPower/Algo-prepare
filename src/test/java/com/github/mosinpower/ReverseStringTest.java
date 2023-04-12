package com.github.mosinpower;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Write a function that reverses a string. The input string is given as an array of characters s.
 * <p>
 * You must do this by modifying the input array in-place with O(1) extra memory.
 */
public class ReverseStringTest {

    public void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }
    }

    @Test
    public void test1(){
        char[] input = new char[]{'h','e','l','l','o'};
        char[] expected = new StringBuilder(new String(input)).reverse().toString().toCharArray();
        reverseString(input);
        Assertions.assertArrayEquals(expected, input);
    }


    @Test
    public void test2(){
        char[] input = new char[]{'H','a','n','n','a','h'};
        char[] expected = new StringBuilder(new String(input)).reverse().toString().toCharArray();
        reverseString(input);
        Assertions.assertArrayEquals(expected, input);
    }
}
