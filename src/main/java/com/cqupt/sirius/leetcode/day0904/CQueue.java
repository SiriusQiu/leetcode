package com.cqupt.sirius.leetcode.day0904;

import java.util.Stack;

public class CQueue {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    public CQueue() {

    }

    public void appendTail(int value) {
        stack1.add(value);
    }

    public int deleteHead() {
        if (stack2.empty()&&stack1.empty()) return -1;
        if (stack1.empty()) while (!stack1.isEmpty()) stack2.add(stack1.pop());
        return stack2.pop();
    }
}
