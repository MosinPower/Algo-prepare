package com.github.mosinpower;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Best Time to Buy and Sell Stock
 * <p>
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
 * <p>
 * On each day, you may decide to buy and/or sell the stock.
 * You can only hold at most one share of the stock at any time.
 * However, you can buy it then immediately sell it on the same day.
 * <p>
 * Find and return the maximum profit you can achieve.
 */
public class BuyAndSellStocks2Test {


    public int maxProfit(int[] prices) {
        if(prices.length == 0 || prices.length==1){
            return 0;
        }
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i -1];
            if(diff > 0) {
                max = max + diff;
            }
        }
        return max;
    }


    /**
     * Input: prices = [7,1,5,3,6,4]
     * Output: 7
     * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
     * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
     * Total profit is 4 + 3 = 7.
     */
    @Test
    public void test1(){
        int[] prices = new int[]{7,1,5,3,6,4};
        int expected = 7;
        int actual = maxProfit(prices);
        Assertions.assertEquals(expected, actual);
    }

    /**
     * Input: prices = [1,2,3,4,5]
     * Output: 4
     * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
     * Total profit is 4.
     */
    @Test
    public void test2(){
        int[] prices = new int[]{1,2,3,4,5};
        int expected = 4;
        int actual = maxProfit(prices);
        Assertions.assertEquals(expected, actual);
    }

    /**
     * Input: prices = [7,6,4,3,1]
     * Output: 0
     * Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.
     */
    @Test
    public void test3(){
        int[] prices = new int[]{7,6,4,3,1};
        int expected = 0;
        int actual = maxProfit(prices);
        Assertions.assertEquals(expected, actual);
    }
}
