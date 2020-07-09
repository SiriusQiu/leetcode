package com.cqupt.sirius.leetcode.day0709;

import java.util.LinkedList;
import java.util.Queue;

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

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strings = new String[]{"0000"};
        String str = "8888";
        System.out.println(solution.openLock(strings, str));
    }
}
