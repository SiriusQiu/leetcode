package com.cqupt.sirius.leetcode.day0826;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    static final char[][] mark = new char[][]{{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
    public List<String> letterCombinations(String digits) {
        StringBuilder stringBuilder = new StringBuilder();
        List<String> result = new ArrayList<>();
        letterCombinations(digits, 0, result, stringBuilder);
        return result;
    }
    public void letterCombinations(String digits, int index, List<String> result, StringBuilder stringBuilder){
        if (index == digits.length()) {
            result.add(stringBuilder.toString());
            return;
        }
        int cur = digits.charAt(index)-'2';
        if (cur < 0) throw new IllegalArgumentException();
        char[] chars = mark[cur];
        for (char c : chars){
            stringBuilder.append(c);
            letterCombinations(digits, index+1, result, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
        return;
    }
}
