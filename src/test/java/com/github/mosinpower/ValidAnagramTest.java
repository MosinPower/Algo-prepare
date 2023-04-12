package com.github.mosinpower;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/** Valid Anagram
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 */
public class ValidAnagramTest {


    public boolean isAnagram(String s, String t) {
        char[] counters = new char[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            counters[c - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            counters[c - 'a']--;
        }

        Arrays.sort(counters);
        return counters[0] == 0 && counters[25] == 0;
    }
    public boolean isAnagramCanBeBetter(String s, String t) {
        char[] cc = s.toCharArray();
        char[] tt = t.toCharArray();
        Arrays.sort(cc);
        Arrays.sort(tt);
        return Arrays.equals(cc, tt);
    }

    @Test
    public void test1(){
        String s = "rat";
        String t = "car";

        boolean actual = isAnagram(s, t);
        Assertions.assertFalse(actual);
    }


    @Test
    public void test2(){
        String s = "anagram";
        String t = "nagaram";

        boolean actual = isAnagram(s, t);
        Assertions.assertTrue(actual);
    }
}
