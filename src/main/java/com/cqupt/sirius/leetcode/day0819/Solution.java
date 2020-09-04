package com.cqupt.sirius.leetcode.day0819;

import java.util.Arrays;
import java.util.stream.Stream;

public class Solution {
    public int countSubstrings(String s) {
        if (s==null||s.length()==0) return 0;
        char[] chars = s.toCharArray();
        int result = 0;
        boolean[][] dp = new boolean[chars.length][chars.length];
        for (int i = 0; i < chars.length; i++){
            result++;               //先加自己
            for (int j = 0; j < i; j++){
                if ((j<2||dp[i-1][j-2])&&chars[i]==chars[i-j-1]){
                    result++;
                    dp[i][j] = true;
                }
            }
        }
        return result;
    }


}
