package com.github.mosinpower;


import org.javatuples.Pair;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Даны даты заезда и отъезда каждого гостя.
 * Для каждого гостя дата заезда строго раньше даты отъезда
 * (то есть каждый гость останавливается хотя бы на одну ночь).
 * В пределах одного дня считается, что сначала старые гости выезжают, а затем въезжают новые.
 * Найти максимальное число постояльцев, которые одновременно проживали в гостинице (считаем, что измерение количества постояльцев происходит в конце дня).
 * <p>
 * sample = [ (1, 2), (1, 3), (2, 4), (2, 3)]
 */
public class HotelTest {


    private int maxCountInSameTime(List<Pair<Integer, Integer>> list) {
        int res = 0;
        Map<Integer, Integer> arrived = new HashMap<>();
        Map<Integer, Integer> leaved = new HashMap<>();
        for (Pair<Integer, Integer> startEnd : list) {
            arrived.put(startEnd.getValue0(), arrived.getOrDefault(startEnd.getValue0(), 0) + 1);
            leaved.put(startEnd.getValue1(), leaved.getOrDefault(startEnd.getValue1(), 0) + 1);
        }

        List<Integer> markedDays = Stream.of(arrived.keySet(),leaved.keySet())
                .flatMap(Collection::stream)
                .sorted()
                .collect(Collectors.toList());

        int current = 0;
        for (Integer markedDay : markedDays) {
            current = current + arrived.getOrDefault(markedDay, 0) - leaved.getOrDefault(markedDay, 0);
            if(current > res) {
                res = current;
            }
        }

        return res;
    }


    @Test
    void test1() {
        List<Pair<Integer, Integer>> input = Arrays.asList(new Pair<>(1, 4), new Pair<>(2, 5), new Pair<>(3, 6), new Pair<>(4, 7));
        int expected = 4;

        int actual = maxCountInSameTime(input);
        assertEquals(expected, actual);
    }

    @Test
    void test2() {
        List<Pair<Integer, Integer>> input = Arrays.asList(new Pair<>(1, 2), new Pair<>(1, 3), new Pair<>(2, 4), new Pair<>(2, 3));
        int expected = 4;

        int actual = maxCountInSameTime(input);
        assertEquals(expected, actual);
    }


//плохо, полный перебор, огромная сложность
//   private int badSolution(List<Pair<Integer, Integer>> list) {
//       Map<Integer, Integer> map = new HashMap<>();
//       for(Pair<Integer, Integer> startAndEnd: list) {
//           for (int i = startAndEnd.getValue0(); i <= startAndEnd.getValue1() ; i++) {
//               Integer count = map.getOrDefault(i, 0);
//               map.put(i, count + 1);
//           }
//       }
//
//       return Collections.max(map.values());
//   }
}
