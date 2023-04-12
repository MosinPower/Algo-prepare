package com.github.mosinpower;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * First Unique Character in a String
 * <p>
 * Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
 */
public class FirstUniqCharTest {


    public int firstUniqChar(String s) {
        if(s.isEmpty()) {
            return -1;
        }

        int min = -1;
        for (char c = 'a';  c <= 'z' ; c++) {
            int first = s.indexOf(c);
            int last = s.lastIndexOf(c);
            if(first == last && first != -1) {
                if(min == -1 || first < min) {
                    min = first;
                }
            }
        }
        return min;

    }

    public int firstUniqCharCanBeBetter(String s) {
        HashMap<Character, List<Integer>> charAndIndexes = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            List<Integer> indexes = charAndIndexes.getOrDefault(cur, new ArrayList<>());
            indexes.add(i);
            charAndIndexes.put(cur, indexes);
        }

        return charAndIndexes.values().stream()
                        .filter(e -> e.size() == 1)
                        .flatMap(Collection::stream)
                        .sorted()
                        .findFirst()
                        .orElse(-1);

    }



    @Test
    public void test1(){
        String s = "leetcode";
        int expected = 0;
        int actual = firstUniqCharCanBeBetter(s);
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void test2(){
        String s = "aabb";
        int expected = -1;
        int actual = firstUniqChar(s);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void test3(){
        String s = "loveleetcode";
        int expected = 2;
        int actual = firstUniqChar(s);
        Assertions.assertEquals(expected, actual);
    }
}
