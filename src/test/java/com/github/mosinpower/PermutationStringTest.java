package com.github.mosinpower;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Permutation in String
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 * In other words, return true if one of s1's permutations is the substring of s2.
 */
public class PermutationStringTest {

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        Map<Character, Integer> s1CharAndCounter = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            Integer counter = s1CharAndCounter.getOrDefault(s1.charAt(i), 0);
            s1CharAndCounter.put(s1.charAt(i), counter + 1);
        }

        int windowSize = s1.length();

        HashMap<Character, Integer> s2CharAndCounter = new HashMap<>();
        for (int i = 0; i < windowSize; i++) {
            Integer counter = s2CharAndCounter.getOrDefault(s2.charAt(i), 0);
            s2CharAndCounter.put(s2.charAt(i), counter + 1);
        }
        if (isPermutation(s1CharAndCounter, s2CharAndCounter)) {
            return true;
        }

        for (int i = 1; i <= s2.length() - windowSize; i++) {
            char prev = s2.charAt(i - 1);
            char next = s2.charAt(i + windowSize - 1);
            removePrev(s2CharAndCounter, prev);
            putNext(s2CharAndCounter, next);

            if (isPermutation(s1CharAndCounter, s2CharAndCounter)) {
                return true;
            }
        }

        return false;
    }

    private void putNext(HashMap<Character, Integer> map, char next) {
        Integer nC = map.getOrDefault(next, 0);
        map.put(next, nC + 1);
    }

    public void removePrev(Map<Character, Integer> map, char prev) {
        Integer integer = map.get(prev);
        if(integer == 1) {
            map.remove(prev);
        } else{
            map.put(prev, integer-1);
        }
    }

    public boolean isPermutation(Map<Character, Integer> m1, Map<Character, Integer> m2) {
        if (m1.size() != m2.size()) {
            return false;
        }

        for (Map.Entry<Character, Integer> pair1 : m1.entrySet()) {
            Integer c2 = m2.get(pair1.getKey());
            if (!pair1.getValue().equals(c2)) {
                return false;
            }
        }

        return true;
    }


    @Test
    public void test0() {
        String s1 = "adc";
        String s2 = "dcda";

        Assertions.assertTrue(checkInclusion(s1,s2));
    }
    @Test
    public void test1() {
        String s1 = "ab";
        String s2 = "eidbaooo";

        Assertions.assertTrue(checkInclusion(s1,s2));
    }

    @Test
    public void test2() {
        String s1 = "ab";
        String s2 = "eidboaoo";

        Assertions.assertFalse(checkInclusion(s1,s2));
    }

}
