package com.github.mosinpower;


import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Слияние отрезков:
 *
 * Вход: [1, 3] [100, 200] [2, 4]
 * Выход: [1, 4] [100, 200]
 */
public class MergeRangesTest {

    private List<Tuple> merge(List<Tuple> list) {
        list.sort(Comparator.comparing(Tuple::getLeft)); //nlogn

        LinkedList<Tuple> res = new LinkedList<>();
        for (Tuple cur : list) {
            if(res.isEmpty()) { // for first element
                res.add(cur);
                continue;
            }
            Tuple prev = res.getLast();
            int rightPrev = prev.getRight();
            int leftCur = cur.getLeft(); //1,2 - 3,4
            int rightCur = cur.getRight(); //1,2 - 2,4
            if(leftCur - rightPrev <= 1  ) {
                prev.setRight(Math.max(rightCur, rightPrev));
            } else {
                res.add(cur);
            }

        }

        return res;
    }


    @Test
    void test1() {
        List<Tuple> input = Arrays.asList(new Tuple(1,3), new Tuple(100,200), new Tuple(2,4));

        List<Tuple> merge = merge(input);
        System.out.println(merge);
        assertEquals(2, merge.size());


    }



    class Tuple {
        int left;
        int right;

        public Tuple(int left, int right) {
            this.left = left;
            this.right = right;
        }

        public int getLeft() {
            return left;
        }

        public void setLeft(int left) {
            this.left = left;
        }

        public int getRight() {
            return right;
        }

        public void setRight(int right) {
            this.right = right;
        }

        @Override
        public String toString() {
            return "[" + left +"," + right + "]";
        }
    }


}
