package com.github.mosinpower;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * <a href="https://leetcode.com/problems/maximize-distance-to-closest-person/">...</a>
 * You are given an array representing a row of seats where seats[i] = 1
 * represents a person sitting in the ith seat, and seats[i] = 0 represents that the ith seat is empty (0-indexed).
 * -
 * There is at least one empty seat, and at least one person sitting.
 * -
 * Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized.
 * -
 * Return that maximum distance to the closest person.
 * Constraints:
 * -
 * 2 <= seats.length <= 2 * 104
 * seats[i] is 0 or 1.
 * At least one seat is empty.
 * At least one seat is occupied.
 */
public class MaximizeDistanceToClosestPersonTest {


    public int getMaxDistToClosestPerson(int[] seats) {
        int prevStartIndex = 0;
        int counter = 0;

        int maxFreeSpace = 1;
        while (counter < seats.length) {
            if(seats[counter] == 1) {
                int space = (counter - prevStartIndex) / 2;
                if(space > maxFreeSpace) {
                    maxFreeSpace = space;
                }
                prevStartIndex = counter;
            }
            counter++;
        }
        int fromFirstMaxSeat = 0;
        if(seats[0] == 0) {
            for (int seat : seats) {
                if (seat != 0) {
                    break;
                }
                fromFirstMaxSeat++;
            }
        }

        int fromLastMaxSeat = 0;
        if(seats[seats.length - 1] == 0) {
            for (int i = seats.length -1; i >= 0; i--) {
                if(seats[i] != 0) {
                    break;
                }
                fromLastMaxSeat++;
            }
        }
        int boundaryMax = Math.max(fromFirstMaxSeat, fromLastMaxSeat);

        return Math.max(maxFreeSpace, boundaryMax);
    }

    /**
     * Input: seats = [1,0,0,0,1,0,1]
     * Output: 2
     * Explanation:
     * If Alex sits in the second open seat (i.e. seats[2]), then the closest person has distance 2.
     * If Alex sits in any other open seat, the closest person has distance 1.
     * Thus, the maximum distance to the closest person is 2.
     */
    @Test
    public void test1() {
        int[] seats = new int[]{1, 0, 0, 0, 1, 0, 1};
        int expected = 2;

        int actual = getMaxDistToClosestPerson(seats);
        Assertions.assertEquals(expected, actual);
    }


    /**
     * Input: seats = [1,0,0,0]
     * Output: 3
     * Explanation:
     * If Alex sits in the last seat (i.e. seats[3]), the closest person is 3 seats away.
     * This is the maximum distance possible, so the answer is 3.
     */
    @Test
    public void test2() {
        int[] seats = new int[]{1, 0, 0, 0};
        int expected = 3;

        int actual = getMaxDistToClosestPerson(seats);
        Assertions.assertEquals(expected, actual);
    }


    /**
     * Input: seats = [0,1]
     * Output: 1
     */
    @Test
    public void test3() {
        int[] seats = new int[]{0, 1};
        int expected = 1;

        int actual = getMaxDistToClosestPerson(seats);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test4() {
        int[] seats = new int[]{0,0,1};
        int expected = 2;

        int actual = getMaxDistToClosestPerson(seats);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test5() {
        int[] seats = new int[]{1,0,0,0};
        int expected = 3;

        int actual = getMaxDistToClosestPerson(seats);
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void test6() {
        int[] seats = new int[]{1,0,0,1};
        int expected = 1;

        int actual = getMaxDistToClosestPerson(seats);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test7() {
        int[] seats = new int[]{0,1,0,0,0,0,0,0,1,1,0,1,1};
        int expected = 3;

        int actual = getMaxDistToClosestPerson(seats);
        Assertions.assertEquals(expected, actual);
    }


}
