package com.cqupt.sirius.leetcode.day0716;

import java.util.*;
import java.util.stream.IntStream;

public class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null && matrix.length < 2) return;
        for (int[] row : matrix){
            for (int i = 0; i < row.length/2; i ++){
                int j = row.length - i - 1;
                int k = row[i];
                row[i] = row[j];
                row[j] = k;
            }
        }
        for (int i = 0; i < matrix.length - 1; i++){
            for (int j = 0; j < matrix[i].length-i-1;j++){
                int indexi = matrix[i].length-1 - j;
                int indexj = matrix.length-1 - i;
                int temp = matrix[indexi][indexj];
                matrix[indexi][indexj] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }
    public void setZeroes(int[][] matrix) {
        if (matrix == null && matrix.length == 0) return;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j< matrix[0].length;j++){
                if (matrix[i][j] == 0){
                    String ele = "x" + i + "y"+ j;
                    set.add(ele);

                }
            }
        }
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()){
            String ele = iterator.next();
            int y = ele.indexOf("y");
            int i = Integer.valueOf(ele.substring(1, y));
            int j = Integer.valueOf(ele.substring(y+1, ele.length()));
            for (int k = 0; k < matrix.length; k++){
                matrix[k][j] = 0;
            }
            for (int k = 0; k < matrix[0].length; k++){
                matrix[i][k] = 0;
            }
        }
    }
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null && matrix.length == 0) return null;
        int i = 0;
        int j = 0;
        List<Integer> list = new ArrayList<>();
        boolean flag = true;
        while (i < matrix.length&&j<matrix[0].length){
            list.add(matrix[i][j]);
            if(flag){
                if (i == 0&&j<matrix[0].length-1) {
                    j++;
                    flag = false;
                }else if (j == matrix[0].length-1){
                    i++;
                    flag = false;
                }else {
                    i--;
                    j++;
                }
            }else {
                if (j==0&&i < matrix.length-1){
                    i++;
                    flag = true;
                }else if (i == matrix.length-1){
                    j++;
                    flag = true;
                } else {
                    i++;
                    j--;
                }
            }
        }
        int[] result = new int[list.size()];
        for (int k = 0; k < result.length; k++){
            result[k] = list.get(k);
        }
        return result;
    }

    public String longestPalindrome(String s) {
        int[][] dp = new int[s.length()][s.length()];
        char[] chars = s.toCharArray();
        int max = Integer.MIN_VALUE;
        String result = null;
        for (int i = 0; i < s.length();i++){
            for (int j = i; j<s.length();j++){
                if (isPalindrome(chars, i, j,dp)){
                    if (j-i+1>max){
                        max = j-i+1;
                        result = s.substring(i,j+1);
                    }
                }
            }
        };
        return result;
    }

    public boolean isPalindrome(char[] chars, int left, int right, int[][] dp){
        if (dp[left][right]!=0) return dp[left][right]==1;
        if (left>right||chars[left]!=chars[right]){
            dp[left][right]=-1;
            return false;
        }
        if (left==right){
            dp[left][right]=1;
            return true;
        }
        if (left+1==right||isPalindrome(chars,left+1, right-1,dp)){
            dp[left][right]=1;
            return true;
        }else return false;
    }
    public String longestPalindrome2(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public String reverseWords(String s) {
        Stack<String> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length;){
            while (i<chars.length&&chars[i]==' ') i++;
            StringBuilder stringBuilder = new StringBuilder();
            while (i<chars.length&&chars[i]!=' '){
                stringBuilder.append(chars[i++]);
            }
            if (stringBuilder.length()>0) stack.add(stringBuilder.toString());
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (!stack.empty()){
            stringBuilder.append(stack.pop());
        }
        while (!stack.empty()){
            stringBuilder.append(' ').append(stack.pop());
        }
        return stringBuilder.toString();
    }

    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.reverseWords("  hello world!  "));
    }


}
