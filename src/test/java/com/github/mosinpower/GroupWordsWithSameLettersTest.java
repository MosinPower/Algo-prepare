package com.github.mosinpower;


import org.javatuples.Pair;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * сгруппировать слова по "общим буквам".
 * Sample Input ["eat", "tea", "tan", "ate", "nat", "bat"]
 * Sample Output [ ["ate", "eat", "tea"], ["nat", "tan"], ["bat"] ]
 */
public class GroupWordsWithSameLettersTest {


    private Collection<List<String>> groupWords(String[] words) {
        Map<String, List<String>> collect = Arrays.stream(words)
                .collect(Collectors.groupingBy(e -> {
                    char[] chars = e.toCharArray();
                    Arrays.sort(chars);
                    return new String(chars);
                }));
        return collect.values();
    }


    @Test
    void test1() {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        Collection<List<String>> groups = groupWords(input);
        groups.forEach(System.out::println);

        assertEquals(3, groups.size());



    }


}
