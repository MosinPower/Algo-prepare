package com.github.mosinpower;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class PalindromeLinkedListTest {

    // Definition for singly-linked list.
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }


    //better solution O(1) space
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        //find middle
        while (fast != null
                && fast.next != null // - for odd size
        ) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //reverse slow (from the middle)
        ListNode prev = slow;
        slow = slow.next;
        prev.next = null;
        ListNode temp;
        while (slow != null) {
            temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }
        //check from start and from reversed
        fast = head;
        slow = prev;
        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    public boolean isPalindromeIntuitive(ListNode head) {
        ArrayList<Integer> vals = new ArrayList<>();
        ListNode prev = head;
        while (prev != null) {
            vals.add(prev.val);
            prev = prev.next;
        }

        for (int i = 0; i < vals.size() / 2; i++) {
            Integer left = vals.get(i);
            Integer right = vals.get(vals.size() - 1 - i);
            if (!left.equals(right)) {
                return false;
            }
        }
        return true;
    }

    public ListNode toLinked(int[] vals) {
        ListNode head = new ListNode(vals[0]);
        ListNode prev = head;
        for (int i = 1; i < vals.length; i++) {
            ListNode next = new ListNode(vals[i]);
            prev.next = next;
            prev = next;
        }
        return head;
    }


    @Test
    public void test11() {
        ListNode listNode = toLinked(new int[]{1});
        Assertions.assertTrue(isPalindrome(listNode));
    }

    @Test
    public void test0() {
        ListNode listNode = toLinked(new int[]{1, 2, 1});
        Assertions.assertTrue(isPalindrome(listNode));
    }

    @Test
    public void test1() {
        ListNode listNode = toLinked(new int[]{1, 2, 2, 1});
        Assertions.assertTrue(isPalindrome(listNode));
    }

    @Test
    public void test2() {
        ListNode listNode = toLinked(new int[]{1, 2});
        Assertions.assertFalse(isPalindrome(listNode));
    }

}
