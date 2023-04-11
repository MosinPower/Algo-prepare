package com.github.mosinpower;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

public class FindLeavesSumOfBiTreeTest {


    @AllArgsConstructor
    @Getter
    @Setter
    @Builder
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
    }

    public int getLeavesSum(TreeNode root){
        AtomicInteger sum = new AtomicInteger(0);
        getLeavesSumHelper(sum, root);
        return sum.get();
    }

    public void getLeavesSumHelper(AtomicInteger sum, TreeNode node) {
        if(node.getLeft() == null && node.getRight() == null) {
            int curSum = sum.get();
            sum.set(node.getVal() + curSum);
        }
        if(node.getLeft() != null) {
            getLeavesSumHelper(sum, node.getLeft());
        }
        if(node.getRight() != null) {
            getLeavesSumHelper(sum, node.getRight());
        }

    }


    /**
     *            5
     *         4     2
     *       1  6       3
     *                7
     */
    @Test
    public void test1(){
        TreeNode root = TreeNode.builder()
                .val(5)
                .left(TreeNode.builder().val(4)
                        .left(new TreeNode(null, null, 1))
                        .right(new TreeNode(null, null, 6))
                        .build())
                .right(TreeNode.builder().val(2)
                        .right(TreeNode.builder().val(3)
                                .left(new TreeNode(null, null, 7))
                                .build())
                        .build())
                .build();


        int actual = getLeavesSum(root);
        Assertions.assertEquals(14, actual);
    }
}
