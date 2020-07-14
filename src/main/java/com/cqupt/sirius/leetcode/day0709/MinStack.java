package com.cqupt.sirius.leetcode.day0709;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    private int min;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    public void push(int x) {
        min = x < min ? x : min;
        stack.push(x);
        minStack.push(min);
    }
    //
    public void pop() {
        if (stack.empty()) return;
        stack.pop();
        minStack.pop();
        if (!minStack.empty()){
            min = minStack.peek();
        }
    }

    public int top() {
        if (stack.empty()) return -1;
        return stack.peek();
    }

    public int getMin() {
        if (stack.empty()) return min;
        return minStack.peek();
    }

    public static void main(String[] args) {

        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(2);
        minStack.top();
        minStack.getMin();
        minStack.pop();
        minStack.getMin();
        minStack.top();
    }
}
