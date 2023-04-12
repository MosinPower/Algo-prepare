package com.github.mosinpower;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Valid Anagram
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 */
public class ValidPalindromeTest {


    public boolean isPalindrome(String s) {
        String cleanedS = s.toLowerCase().replaceAll("[^0-9a-z]", "");
        for(int i = 0; i < cleanedS.length() / 2 ; i++) {
            char left = cleanedS.charAt(i);
            char right = cleanedS.charAt(cleanedS.length() - i - 1);
            if(left != right) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindromeBetter(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int start = 0;
        int last = s.length() - 1;
        while (start <= last) {
            char currFirst = s.charAt(start);
            char currLast = s.charAt(last);
            if (!Character.isLetterOrDigit(currFirst)) {
                start++;
            } else if (!Character.isLetterOrDigit(currLast)) {
                last--;
            } else {
                if (Character.toLowerCase(currFirst) != Character.toLowerCase(currLast)) {
                    return false;
                }
                start++;
                last--;
            }
        }
        return true;
    }




    @Test
    public void test1() {
        String s = "race a car";
        boolean actual = isPalindrome(s);
        Assertions.assertFalse(actual);
    }


    @Test
    public void test2() {
        String s = "A man, a plan, a canal: Panama";
        boolean actual = isPalindrome(s);
        Assertions.assertTrue(actual);
    }

    @Test
    public void test3() {
        String s = "a.";
        boolean actual = isPalindrome(s);
        Assertions.assertTrue(actual);
    }
}
