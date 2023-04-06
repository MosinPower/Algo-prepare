package com.github.mosinpower;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Дан список интов, повторяющихся элементов в списке нет.
 * Нужно преобразовать это множество в строку, сворачивая соседние по числовому ряду числа в диапазоны. Примеры:
 * [1,4,5,2,3,9,8,11,0] => "0-5,8-9,11"
 * [1,4,3,2] => "1-4"
 * [1,4] => "1,4"
 */
class CompressNumbersTest {


    public String compress(int[] arr1) {
        Arrays.sort(arr1);

        class Range implements Comparable<Range>{
            int first;
            int last;

            Range(int number) {
                first = number;
                last = number;
            }

            boolean isInRange(int number){
                if(number > last && number - last == 1) {
                    last++;
                    return true;
                }
                if(number < first && first - number == 1) {
                    first--;
                    return true;
                }
                if(number <= last && number >= first) {
                    return true;
                }

                return false;
            }
            public Integer getFirst() {
                return this.first;
            }

            @Override
            public int compareTo(Range o) {
                return Integer.compare(first, o.first);
            }

            @Override
            public String toString() {
                if(first == last) {
                    return String.valueOf(first);
                } else {
                    return first + "-" + last;
                }
            }
        }

        LinkedList<Range> list = new LinkedList<>();
        list.add(new Range(arr1[0]));
        for (int i = 1; i < arr1.length; i++) {
            boolean inRange= list.getLast().isInRange(arr1[i]);
            if(!inRange) {
                list.add(new Range(arr1[i]));
            }
        }
        list.sort(Comparator.comparing(Range::getFirst));

        return list.toString();

    }

    @Test
    void fromDescription1() {
        int[] input = {1,4,5,2,3,9,8,11,0};
        String expected = "[0-5, 8-9, 11]";

        String actual = compress(input);

        assertEquals(expected, actual);
    }

    @Test
    void fromDescription2() {
        int[] input = {1,4,3,2};
        String expected = "[1-4]";
        String actual = compress(input);

        assertEquals(expected, actual);
    }


    @Test
    void fromDescription3() {
        int[] input = {1,4};
        String expected = "[1, 4]";
        String actual = compress(input);

        assertEquals(expected, actual);
    }
}