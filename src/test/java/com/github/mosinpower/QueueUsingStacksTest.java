package com.github.mosinpower;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;


public class QueueUsingStacksTest {



    class MyQueue {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        int count = 0;

    public MyQueue() {

        }

        public void push(int x) {

            while (!s1.isEmpty()) {
                s2.add(s1.pop());
            }
            s1.push(x);

            while (!s2.isEmpty()) {
                s1.add(s2.pop());
            }
        }

        public int pop() {

            return s1.pop();
        }

        public int peek() {
            return s1.peek();
        }
        public boolean empty() {
            return s1.isEmpty() ;
        }
    }


    @Test
    public void test1(){
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        Assertions.assertTrue(myQueue.peek() == 1);
        Assertions.assertTrue(myQueue.pop() == 1);
        Assertions.assertFalse(myQueue.empty());
    }



    @Test
    public void test2(){
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        myQueue.push(4);

        Assertions.assertTrue(myQueue.pop() == 1);

        myQueue.push(5);


        Assertions.assertTrue(myQueue.pop() == 2);
        Assertions.assertTrue(myQueue.pop() == 3);
        Assertions.assertTrue(myQueue.pop() == 4);
        Assertions.assertTrue(myQueue.pop() == 5);

    }

}
