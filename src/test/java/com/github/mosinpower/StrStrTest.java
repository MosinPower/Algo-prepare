package com.github.mosinpower;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/** Implement strStr()
 *Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack
 */
class StrStrTest {
    public int strStr(String haystack, String needle) {
        
        int window = needle.length();
        for(int i = 0; i <= haystack.length() - needle.length(); i++ ){
            int counter = 0;
            for(int j = i; counter < window; j++) {
                char c = needle.charAt(counter);
                char c1 = haystack.charAt(j);
                if(c != c1) {
                    break;
                } 
                counter++;
            }
            if(counter == window) {
                return i;
            }
        }
        return -1;
        
    }

    @Test
    public void test1(){
        String s1 = "sadbutsad";
        String s2 = "sad";
        Assertions.assertEquals(0, strStr(s1, s2));
    }
    @Test
    public void test2(){
        String s1 = "leetcode";
        String s2 = "leeto";
        Assertions.assertEquals(-1, strStr(s1, s2));
    }
}