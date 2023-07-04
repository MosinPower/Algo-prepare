package com.github.mosinpower;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

public class NumbersOfRecentCallsTest {

    class RecentCounter {
        LinkedList<Integer> list = new LinkedList<>();
        public RecentCounter() {
        }

        public int ping(int t) {
            list.add(t);
            while(t - list.getFirst() > 3000) {
                list.pollFirst();
            }
            return list.size();
        }
    }

    @Test
    public void test1(){
        RecentCounter recentCounter = new RecentCounter();
        Assertions.assertEquals(1,recentCounter.ping(1));
        Assertions.assertEquals(2,recentCounter.ping(100));
        Assertions.assertEquals(3,recentCounter.ping(3001));
        Assertions.assertEquals(3,recentCounter.ping(3002));


    }

}
