package com.cqupt.sirius.leetcode.day0709;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {
    private static class Node{
        int a;
        int b;
        int c;
        int d;
        int value;
        public Node(int a, int b, int c, int d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }
        Node getAup(){
            return new Node((a+1)%10,b,c,d);
        }
        Node getBup(){
            return new Node(a,(b+1)%10,c,d);
        }
        Node getCup(){
            return new Node(a,b,(c+1)%10,d);
        }
        Node getDup(){
            return new Node(a,b,c,(d+1)%10);
        }
        Node getAdown(){
            return new Node((a+9)%10,b,c,d);
        }
        Node getBdown(){
            return new Node(a,(b+9)%10,c,d);
        }
        Node getCdown(){
            return new Node(a,b,(c+9)%10,d);
        }
        Node getDdown(){
            return new Node(a,b,c,(d+9)%10);
        }
        int getIndex(){
            return a*1000 + b*100 + c*10 + d;
        }
    }
    public int openLock(String[] deadends, String target) {
        int[] dp = new int[10000];
        for (String str : deadends){
            int index = getIndexFromStr(str);
            if(index==0) return -1;
            else dp[index] = -1;
        }
        dp[getIndexFromStr(target)] = -2;
        Node head = new Node(0,0,0,0);
        head.value = 0;
        dp[0] = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()){
            Node node = queue.poll();
            Node aUp = node.getAup();
            if(check(queue, dp, aUp, node)){
                return node.value+1;
            };
            Node bUp = node.getBup();
            if(check(queue, dp, bUp, node)){
                return node.value+1;
            };
            Node cUp = node.getCup();
            if(check(queue, dp, cUp, node)){
                return node.value+1;
            }
            Node dUp = node.getDup();
            if(check(queue, dp, dUp, node)){
                return node.value+1;
            };
            Node aDown = node.getAdown();
            if(check(queue, dp, aDown, node)){
                return node.value+1;
            };
            Node bDown = node.getBdown();
            if(check(queue, dp, bDown, node)){
                return node.value+1;
            };
            Node cDown = node.getCdown();
            if(check(queue, dp, cDown, node)){
                return node.value+1;
            };
            Node dDown = node.getDdown();
            if(check(queue, dp, dDown, node)){
                return node.value+1;
            };
        }
        return -1;
    }
    public boolean check(Queue queue, int[] dp, Node node,Node before){
        if (dp[node.getIndex()]==-2){
            return true;
        }else if (dp[node.getIndex()]==0){
            node.value = before.value+1;
            dp[node.getIndex()]=before.value+1;
            queue.add(node);
        }
        return false;
    }

    private int getIndexFromStr(String target){
        char[] chars = target.toCharArray();
        int index = 0;
        for (char num : chars){
            index = index * 10 + num - '0';
        }
        return index;
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char ch : chars){
            if (ch == '('||ch == '['||ch == '{'){
                stack.push(ch);
            }else if (ch == ')'){
                if(!stack.empty()&&stack.peek()=='(') stack.pop();
                else return false;
            }else if (ch == ']'){
                if(!stack.empty()&&stack.peek()=='[') stack.pop();
                else return false;
            }else if (ch == '}'){
                if(!stack.empty()&&stack.peek()=='{') stack.pop();
                else return false;
            }
        }


        return stack.isEmpty();

    }
    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        result[T.length-1] = 0;
        retry:
        for (int i = 0; i < T.length-1; i++){
            int temp = T[i];
            for (int j = i+1; j < T.length; j++){
                if (T[j] > temp){
                    result[i] = j-i;
                    continue retry;
                }
            }
            result[i] = 0;
        }
        return result;
    }

    public int evalRPN(String[] tokens) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        retry:
        for (String token : tokens){
            if (token.length()==1){
                switch (token.toCharArray()[0]){
                    case '+':{
                        int a = stack.pop();
                        int b = stack.pop();
                        stack.push(a+b);
                        continue retry;
                    }case '-':{
                        int a = stack.pop();
                        int b = stack.pop();
                        stack.push(b-a);
                        continue retry;
                    }case '*':{
                        int a = stack.pop();
                        int b = stack.pop();
                        stack.push(a*b);
                        continue retry;
                    }case '/':{
                        int a = stack.pop();
                        int b = stack.pop();
                        stack.push(b/a);
                        continue retry;
                    }
                }
            }
            int num = Integer.valueOf(token);
            stack.push(num);
        }
        return stack.pop();
    }

    public static void main(String[] args) {
//        Solution solution = new Solution();
//        String[] strings = new String[]{"2","1","+","3","*"};
//        String str = "8888";
//        System.out.println(solution.evalRPN(strings));
        String str = "许家铭";
        for (char a : str.toCharArray()){
            System.out.println(a);
            System.out.println((int)a);
        }
    }
}
