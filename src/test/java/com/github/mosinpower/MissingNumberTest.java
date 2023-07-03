package com.github.mosinpower;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MissingNumberTest {

    public int missingNumber(int[] nums) {
        int sum = 0;
        int shouldBeSum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            shouldBeSum += i;
        }
        return nums.length + shouldBeSum - sum;
    }

    @Test
    public void test1(){
        int exp = 2;
        int act = missingNumber(new int[]{3, 0, 1});
        Assertions.assertEquals(exp, act);
    }

    @Test
    public void test2(){
        int exp = 2;
        int act = missingNumber(new int[]{0,1});
        Assertions.assertEquals(exp, act);
    }

    @Test
    public void test3(){
        int exp = 8;
        int act = missingNumber(new int[]{9,6,4,2,3,5,7,0,1});
        Assertions.assertEquals(exp, act);
    }
}
