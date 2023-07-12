package com.github.mosinpower;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 */
public class IsSubsequenceTest {

    public boolean isSubsequence(String s, String t) {
        for (int i = 0, j = 0; i < t.length() && j < s.length(); i++) {
            if(s.charAt(j) == t.charAt(i)){
                j++;
                if(j == s.length()) {
                    return true;
                }
            }
        }
        return false;

    }

    @Test
    public void test1(){
        String s = "abc", t = "ahbgdc";
        assertTrue(isSubsequence(s,t));
    }

    @Test
    public void test3(){
        String s = "acb", t = "ahbgdc";
        assertFalse(isSubsequence(s,t));
    }

    @Test
    public void test2(){
        String s = "axc", t = "ahbgdc";
        assertFalse(isSubsequence(s,t));
    }

}
