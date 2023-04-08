package com.github.mosinpower;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Даны две строки.
 * <p>
 * Написать функцию, которая вернёт True, если из первой строки можно получить вторую, совершив не более 1 изменения (== удаление / замена символа).
 */
public class TwoStringWithOneChangeTest {

    public boolean isEqualsWithOneChange(String s1, String s2) {
        if (Math.abs(s1.length() - s2.length()) > 1) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }
        String longer = s1.length() > s2.length() ? s1 : s2;
        String shorter = s1.length() > s2.length() ? s2 : s1;


        char[] arr1 = longer.toCharArray();
        char[] arr2 = shorter.toCharArray();

        boolean sameLen = arr1.length == arr2.length;
        int mistakes = 0;
        int iter1 = 0;
        int iter2 = 0;
        while (iter1 < arr1.length && iter2 < arr2.length) {
            if (mistakes > 1) {
                return false;
            }
            if (arr1[iter1] == arr2[iter2]) {
                iter1++;
                iter2++;
            } else {
                mistakes++;
                iter1++;
                if (sameLen) {
                    iter2++;
                }
            }
        }

        return mistakes <= 1;
    }


    @Test
    public void testTrue100() {
        String s1 = "aaaaaaaaa";
        String s2 = "aaa1aaaaa";
        Assertions.assertTrue(isEqualsWithOneChange(s1, s2));
    }

    @Test
    public void testTrue101() {
        String s1 = "abcdefg";
        String s2 = "abcefg";
        Assertions.assertTrue(isEqualsWithOneChange(s1, s2));
    }

    @Test
    public void testTrue1() {
        String s1 = "abcd";
        String s2 = "a1cd";
        Assertions.assertTrue(isEqualsWithOneChange(s1, s2));
    }

    @Test
    public void testTrue2() {
        String s1 = "abc1";
        String s2 = "abcd";
        Assertions.assertTrue(isEqualsWithOneChange(s1, s2));
    }

    @Test
    public void testFalse() {
        String s1 = "abc";
        String s2 = "a1cd";
        Assertions.assertFalse(isEqualsWithOneChange(s1, s2));
    }


    @Test
    public void testFalse1() {
        String s1 = "asdfgh";
        String s2 = "as";
        Assertions.assertFalse(isEqualsWithOneChange(s1, s2));
    }

    @Test
    public void testFalse2() {
        String s1 = "abcd";
        String s2 = "ab";
        Assertions.assertFalse(isEqualsWithOneChange(s1, s2));
    }

    @Test
    public void testFalse3() {
        String s1 = "abcd";
        String s2 = "abe";
        Assertions.assertFalse(isEqualsWithOneChange(s1, s2));
    }

    @Test
    public void testFalse4() {
        String s1 = "abcd";
        String s2 = "abe";
        Assertions.assertFalse(isEqualsWithOneChange(s1, s2));
    }

    @Test
    public void test1() {
        String s1 = "";
        String s2 = "";
        Assertions.assertTrue(isEqualsWithOneChange(s1, s2));
    }

    @Test
    public void test2() {
        String s1 = "a";
        String s2 = "";
        Assertions.assertTrue(isEqualsWithOneChange(s1, s2));
    }

    @Test
    public void test3() {
        String s1 = "";
        String s2 = "a";
        Assertions.assertTrue(isEqualsWithOneChange(s1, s2));
    }

    @Test
    public void test4() {
        String s1 = "a1";
        String s2 = "aa";
        Assertions.assertTrue(isEqualsWithOneChange(s1, s2));
    }

    @Test
    public void test5() {
        String s1 = "aa";
        String s2 = "a1";
        Assertions.assertTrue(isEqualsWithOneChange(s1, s2));
    }

    @Test
    public void test6() {
        String s1 = "aaa";
        String s2 = "a1a";
        Assertions.assertTrue(isEqualsWithOneChange(s1, s2));
    }

    @Test
    public void test7() {
        String s1 = "1aa";
        String s2 = "aaa";
        Assertions.assertTrue(isEqualsWithOneChange(s1, s2));
    }

    @Test
    public void test8() {
        String s1 = "aaa";
        String s2 = "1aa";
        Assertions.assertTrue(isEqualsWithOneChange(s1, s2));
    }

    @Test
    public void test9() {
        String s1 = "a1a";
        String s2 = "aaa";
        Assertions.assertTrue(isEqualsWithOneChange(s1, s2));
    }


}
