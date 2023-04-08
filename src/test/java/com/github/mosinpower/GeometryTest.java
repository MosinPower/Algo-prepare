package com.github.mosinpower;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Дан массив точек с целочисленными координатами (x, y). 1,1
 * Определить, существует ли вертикальная прямая, делящая точки на 2 симметричных относительно этой прямой множества.
 * Note: Для удобства точку можно представлять не как массив [x, y], а как объект {x, y}
 */
public class GeometryTest {

    private boolean isToBeSimetry(List<Tuple> list) {

        int sum = list.stream().map(Tuple::getX).mapToInt(Integer::valueOf).sum();
        int x = sum / list.size();

        HashSet<Tuple> withoutPair = new HashSet<>();

        for (Tuple tuple : list) {
            if (tuple.getX() == x) {
                continue;
            }
            Tuple mirror = new Tuple(x * 2 - tuple.getX(), tuple.getY());
            if (withoutPair.contains(mirror)) {
                withoutPair.remove(mirror);
            } else {
                withoutPair.add(tuple);
            }
        }

        return withoutPair.isEmpty();
    }//3,1 5,1 3,2


    @Test
    void test0() {
        List<Tuple> input = Arrays.asList(new Tuple(-10, 1), new Tuple(10, 1));
        assertTrue(isToBeSimetry(input));
    }

    @Test
    void test1() {
        List<Tuple> input = Arrays.asList(new Tuple(1, 1), new Tuple(2, 2));
        assertFalse(isToBeSimetry(input));
    }

    @Test
    void test2() {
        List<Tuple> input = Arrays.asList(new Tuple(1, 1));
        Assertions.assertTrue(isToBeSimetry(input));
    }

    @Test
    void test3() {
        List<Tuple> input = Arrays.asList(new Tuple(1, 1), new Tuple(-1, 1));
        Assertions.assertTrue(isToBeSimetry(input));
    }


    @Test
    void test4() {
        List<Tuple> input = Arrays.asList(new Tuple(1, 1), new Tuple(-1, 1),
                new Tuple(2, 2), new Tuple(-2, 2));
        Assertions.assertTrue(isToBeSimetry(input));
    }


    @Test
    void test5() {
        List<Tuple> input = Arrays.asList(new Tuple(1, 1), new Tuple(0, 0),
                new Tuple(-1, 1), new Tuple(2, 2), new Tuple(-2, 2));
        Assertions.assertTrue(isToBeSimetry(input));
    }


    class Tuple {
        final int x;
        final int y;

        public Tuple(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public String toString() {
            return "[" + x + "," + y + "]";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Tuple tuple = (Tuple) o;

            if (x != tuple.x) return false;
            return y == tuple.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }


}
