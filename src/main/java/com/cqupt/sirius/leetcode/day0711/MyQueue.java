package com.cqupt.sirius.leetcode.day0711;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MyQueue {
    /** Initialize your data structure here. */
    private Stack<Integer> stack;
    private Stack<Integer> bStack;
    public MyQueue() {
        stack = new Stack<>();
        bStack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        while (!stack.empty()){
            bStack.push(stack.pop());
        }
        bStack.push(x);
        while (!bStack.empty()){
            stack.push(bStack.pop());
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return stack.pop();
    }

    /** Get the front element. */
    public int peek() {
        return stack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.empty();
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
    }
}
