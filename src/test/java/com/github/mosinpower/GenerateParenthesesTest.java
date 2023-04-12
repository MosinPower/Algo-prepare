package com.github.mosinpower;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Generate Parentheses
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 */
public class GenerateParenthesesTest {
    private List<String> output;
    private StringBuilder sb;

    private int n;
    private int n2;

    public List<String> generateParenthesis(int n) {
        output = new LinkedList<>();
        sb = new StringBuilder();
        this.n = n;
        n2 = n * 2;
        backtrack(0, 0);
        return output;
    }

    private void backtrack(int opened, int closed) {
        if (sb.length() == n2) {
            output.add(sb.toString());
        } else {
            if (opened < n) {
                sb.append('(');
                backtrack(opened + 1, closed);
                sb.deleteCharAt(sb.length() - 1);
            }

            if (opened > closed) {
                sb.append(')');
                backtrack(opened, closed + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }


    @Test
    public void test1() {
        Assertions.assertEquals(Arrays.asList("()"), generateParenthesis(1));
    }

    @Test
    public void test2() {
        List<String> exp = Arrays.asList("((()))", "(()())", "(())()", "()(())", "()()()");
        List<String> actual = generateParenthesis(3);
        Collections.sort(exp);
        Collections.sort(actual);
        Assertions.assertEquals(exp, actual);
    }



}
