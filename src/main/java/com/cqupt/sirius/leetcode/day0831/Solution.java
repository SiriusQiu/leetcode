package com.cqupt.sirius.leetcode.day0831;


import java.io.BufferedInputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {
    static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int data){
            this.value = data;
        }
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int n = scanner.nextInt();
        int num = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        LinkedList<Integer> maxQueue = new LinkedList<>();
        LinkedList<Integer> minQueue = new LinkedList<>();
        int i = 0;
        int j = 0;
        int count = 0;
        while (i < n&&j<n){
            while (!maxQueue.isEmpty()&&maxQueue.peekFirst()<j) maxQueue.pollFirst();
            while (!minQueue.isEmpty()&&minQueue.peekFirst()<j) minQueue.pollFirst();
            while (!maxQueue.isEmpty()&&arr[maxQueue.peekLast()]<arr[i]) maxQueue.pollLast();
            if (maxQueue.isEmpty()||maxQueue.peekLast()!=i)maxQueue.addLast(i);
            while (!minQueue.isEmpty()&&arr[minQueue.peekLast()]>arr[i]) minQueue.pollLast();
            if (minQueue.isEmpty()||minQueue.peekLast()!=i) minQueue.addLast(i);
            if (maxQueue.peekFirst()-minQueue.peekFirst() <= num){
                count ++;
                if (j < i)j++;
                else i++;
            }else i++;
        }
        System.out.println(count);
    }
    public static void print(int num){
        System.out.print(num + " ");
    }
}
