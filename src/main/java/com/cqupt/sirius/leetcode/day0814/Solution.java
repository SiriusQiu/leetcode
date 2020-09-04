package com.cqupt.sirius.leetcode.day0814;

import java.util.*;

public class Solution {
    static class Node{
        int starti;
        int startj;
        int sum;

        public Node() {
        }

        public Node(int starti, int startj) {
            this.starti = starti;
            this.startj = startj;
        }
    }
    public int maxSubMatrix(int[][] matrix){
        if (matrix==null || matrix.length == 0) return 0;
        Node[][] nodes = new Node[matrix.length][matrix[0].length];
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                Node node = new Node(i,j);
                if (matrix[i][j] == 0) node.sum = 0;
                else if (i==0&&j==0) node.sum = 1;
                else if (i==0||matrix[i-1][j]==0){
                    if (matrix[i][j-1]>0) node.sum = nodes[i][j-1].sum+1;
                    else node.sum=1;
                }else if (j==0||matrix[i][j-1]==0){
                    if (matrix[i-1][j]>0) node.sum = nodes[i-1][j].sum+1;
                    else node.sum=1;
                }else if(matrix[i-1][j-1]==0) node.sum=matrix[i][j];
                else {
                    node.starti = nodes[i-1][j].starti;
                    node.startj = nodes[i][j-1].startj;
                    node.sum = (i-node.starti+1) * (j-node.startj+1);
                }
                if (result<node.sum) result = node.sum;
                nodes[i][j] = node;

            }
        }
        return result;
    }



    public int eqSubArray(int[] arr, int num){
        if (arr==null || arr.length < 2) return 0;
        Stack<Node> stack = new Stack<>();
        int result = subArrayCount(arr.length);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++){
            if (stack.empty()) stack.push(new Node(i,arr[i]));
            else {
                int peek = stack.peek().startj;
                if (peek>=arr[i]) stack.push(new Node(i, arr[i]));
                else if (arr[i] - peek >= num) list.add(stack.pop().starti - i + 1);
                else stack.push(new Node(i, peek));
            }
        }
        return list.size();
    }

    public int subArrayCount(int length){
        return (int)Math.pow(2, length) - length - 1;
    }


    public static void main(String[] args) {
        Random random = new Random();
        int length = random.nextInt(10) + 10;
        int[] arr = new int[length];
        for (int i = 0; i< length; i++){
            arr[i] = random.nextInt(30);
        }
        Solution solution = new Solution();
        Arrays.stream(arr).forEach(solution::print);
        System.out.println();
        System.out.println(solution.eqSubArray(arr, 3));


    }
    public void print(int i){
        System.out.print(i + " ");
    }
}
