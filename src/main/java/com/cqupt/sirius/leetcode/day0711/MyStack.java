package com.cqupt.sirius.leetcode.day0711;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    /** Initialize your data structure here. */
    private Queue<Integer> queue;
    private Queue<Integer> bQueue;
    public MyStack() {
        queue = new LinkedList<>();
        bQueue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int x = 0;
        do {
            x = queue.poll();
            if (!queue.isEmpty()){
                bQueue.add(x);
            }
        }while (!queue.isEmpty());
        Queue<Integer> temp = bQueue;
        bQueue = queue;
        queue = temp;
        return x;
    }

    /** Get the top element. */
    public int top() {
        int x = 0;
        while (!queue.isEmpty()){
            x = queue.poll();
            bQueue.add(x);
        }
        Queue<Integer> temp = bQueue;
        bQueue = queue;
        queue = temp;
        return  x;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
