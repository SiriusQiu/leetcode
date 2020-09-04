package com.cqupt.sirius.leetcode.day0816;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null||matrix.length ==0|| matrix[0].length == 0) return false;
        return  findNumberIn2DArray(matrix, target, 0, 0, matrix.length - 1,matrix[0].length - 1);
    }
    public boolean findNumberIn2DArray(int[][] matrix, int target, int starti, int startj, int endi, int endj) {
        if (starti>endi||startj > endj) return false;
        int midi = starti + (endi - starti)/2;
        int midj = startj + (endj - startj)/2;
        int x = matrix[midi][midj];
        if (x==target) return true;
        else if (x < target) {
            return findNumberIn2DArray(matrix, target, starti,midj+1,midi,endj)
                    || findNumberIn2DArray(matrix, target, midi+1, startj, endi, midj)
                    || findNumberIn2DArray(matrix, target, midi+1, midj + 1,endi, endj);
        }else{
            return findNumberIn2DArray(matrix, target, starti, startj, midi - 1, midj - 1)
                    || findNumberIn2DArray(matrix, target, starti,midj, midi-1,endj)
                    || findNumberIn2DArray(matrix, target, midi, startj, endi, midj - 1);
        }
    }
    public boolean threeConsecutiveOdds(int[] arr) {
        if (arr==null || arr.length <3) return false;
        int count = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i]%2==1) count++;
            else count = 0;
            if (count == 3) return true;
        }
        return false;
    }


    public int minOperations(int n) {
        int mid = n >> 1;
        if (n%2==1){
            return mid*(mid+1);
        }else {
            return mid * mid;
        }
    }

    public int maxDistance(int[] position, int m) {
        int length = position.length;
        quickSort(position, 0, length - 1);
        if (m == 2) return position[length - 1] - position[0];
        int[][] dp = new int[length + 1][m + 1];
        return maxDistance(position, m - 2, 1,position[0], position[length - 1],  dp);
    }
    public void quickSort(int[] arr, int left, int right){
        if (left >= right) return;
        int i = left - 1;
        int j = right + 1;
        int x = arr[left];
        while (i < j){
            while (arr[++i] < x);
            while (arr[--j] > x);
            if (i < j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        quickSort(arr, left, j);
        quickSort(arr, j+1, right);
    }
    public int maxDistance(int[] position, int m, int index, int left, int right, int[][] dp){
        if (dp[index][m] > 0) return dp[index][m];
        int end = position.length -m;
        int result = Integer.MIN_VALUE;
        if (m == 1){
            for (int i = index; i < end; i ++){
                int cur = Math.min(Math.abs(left - position[i]),Math.abs(right - position[i]));
                result = cur > result? cur: result;
            }
        }else {
            for (int i = index; i < end; i++){
                int  cur = Math.abs(left - position[i]);
                int max = maxDistance(position, m - 1, i + 1, position[i],right, dp);
                cur = max < cur? max:cur;
                result = cur > result? cur: result;
            }
        }
        dp[index][m] = result;
        return result;
    }
    public int minDays(int n) {
        if (n == 1) return 1;
        int[] dp = new int[n + 1];
        return minDays(n, dp);
    }
    public int minDays(int n, int[] dp){
        if (n == 1) return 1;
        int result;
        if (!(n%2==0)&&!(n%3==0)){
            result = minDays(n-1)+1;
        }else if (n%2==0&&n%3==0){
            int div2 = minDays(n/2) + 1;
            int div3 = minDays(n/3) + 1;
            result =  div2<div3?div2:div3;
        }else if (n%2==0){
            result =  minDays(n/2)+1;
        }else result = minDays(n/3) + 1;
        dp[n] = result;
        return result;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10};
        Solution solution = new Solution();
        solution.maxDistance(arr, 4);
        IntStream.of(arr).forEach(solution::print);
        System.out.println();
        solution.quickSort(arr, 0, arr.length - 1);
        IntStream.of(arr).forEach(solution::print);
        System.out.println();
        Stream.empty().sorted();
    }
    public void print(int i){
        System.out.print(i + " ");
    }
    class Apple{
        String color;

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }
    }
    //一个过滤功能
    public static List<Apple> filterGreenApples(List<Apple> inventory){
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory){
            if ("green".equals(apple.getColor())) result.add(apple);
        }
        return result;
    }
}
