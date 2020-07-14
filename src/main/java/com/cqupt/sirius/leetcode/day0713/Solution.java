package com.cqupt.sirius.leetcode.day0713;

import java.util.*;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        boolean[] booleans = new boolean[nums.length];
        Arrays.fill(booleans, false);
        List<List<Integer>> lists = new ArrayList<>();
        int[] path = new int[nums.length];
        dfs(nums, booleans, 0, lists, path);
        return lists;
    }

    public void dfs(int[] nums, boolean[] booleans, int n, List<List<Integer>> lists, int[] path){
        if (n == nums.length){
            List<Integer> list = new ArrayList<>();
            Arrays.stream(path).forEach(i->list.add(i));
            lists.add(list);
        }
        for (int i = 0; i < nums.length; i++){
            if (!booleans[i]){
                path[n] = nums[i];
                booleans[i] = true;
                dfs(nums, booleans, n+1, lists, path);
                booleans[i] = false;
            }
        }
    }

    public List<List<String>> solveNQueens(int n, int current, boolean[] col, boolean[] dia, boolean[] codia, List<List<String>> result, int[] path){
        if(n == current){
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++){
                StringBuilder stringBuilder = new StringBuilder();
                for (int j = 0; j < n; j++){
                    if (path[i]==j) stringBuilder.append('Q');
                    else stringBuilder.append('.');
                }
                list.add(stringBuilder.toString());
            }
            result.add(list);
            return result;
        }
        for (int i = 0; i < n; i++){
            if (!col[i]&&!dia[current+i]&&!codia[current-i+n-1]){
                col[i] = true;
                dia[current+i] = true;
                codia[current-i+n-1] = true;
                path[current] = i;
                solveNQueens(n, current+1, col, dia, codia, result, path);
                col[i] = false;
                dia[current+i] = false;
                codia[current-i+n-1] = false;
            }
        }
        return result;
    }


    public List<List<String>> solveNQueens(int n) {
        boolean[] col = new boolean[n];
        boolean[] dia = new boolean[2 * n - 1];
        boolean[] codia = new boolean[2 * n - 1];
        int[] path = new int[n];
        Arrays.fill(col, false);
        Arrays.fill(dia, false);
        Arrays.fill(codia, false);
        List<List<String>> result = new ArrayList<>();
        solveNQueens(n, 0, col, dia, codia, result, path);
        return result;
    }

    public int lengthOfLongestSubstring(String s) {
        if (s==null || s.length() == 0) return 0;
        char[] chars = s.toCharArray();
        int[] index = new int[256];
        Arrays.fill(index, -1);
        int start = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < chars.length; i++){
            if (index[chars[i]]<i){
                start = index[chars[i]] == -1||index[chars[i]] < start ? start : index[chars[i]]+1;
                index[chars[i]] = i;
            }
            max = max < i - start + 1 ? i-start + 1: max;
        }
        return max;
    }
    public int pivotIndex(int[] nums) {
        int[] sum = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            if (i == 0) sum[i] = nums[i];
            else sum[i] = sum[i-1] + nums[i];
        }
        for (int i = 0; i < nums.length; i++){
            int left = i==0?0:sum[i-1];
            int right = i == nums.length-1?0:sum[nums.length-1]-sum[i];
            if (left==right) return i;
        }
        return -1;
    }
    //找到大于等于target的第一个数
    public int searchInsert(int[] nums, int target) {
        if (target > nums[nums.length-1]) return nums.length;
        int left = 0;
        int right = nums.length-1;
        while (left < right){
            int mid = (left+right)/2;
            if (nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                right = mid;
            }else {
                left = mid+1;
            }
        }
        return left;
    }
    public int[][] merge(int[][] intervals) {

        return null;
    }
    private void quickSort(int[] nodes, int left, int right){
        if (left >= right) return;;
        int i = left -1;
        int j = right+1;
        int x = nodes[left];
        while (i < j){
            while (nodes[++i]<x);
            while (nodes[--j]>x);
            if (i < j){
                int temp = nodes[i];
                nodes[i] = nodes[j];
                nodes[j] = temp;
            }
        }
        quickSort(nodes, left, j);
        quickSort(nodes, j+1, right);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        //System.out.println(solution.solveNQueens(4));
        //System.out.println(solution.lengthOfLongestSubstring("abba"));
        int[][] inputs = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        System.out.println(solution.merge(inputs));
    }
}
