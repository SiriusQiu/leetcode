package com.cqupt.sirius.leetcode.day0825;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    static StringBuilder stringBuilder = new StringBuilder();
    static Set<String> set = new HashSet<>();
    static List<List<Integer>> result = new ArrayList<>();
    static int[] temp = new int[15];
    public List<List<Integer>> findSubsequences(int[] nums) {
        set.clear();
        result.clear();
        if (nums==null||nums.length < 2) return result;


        for (int i = 0; i < nums.length; i++){
            stringBuilder.append(nums[i]);
            temp[0] = nums[i];
            findSubsequences(nums, nums[i], i+1, 1);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }

        return result;
    }
    public void findSubsequences(int[] nums,
                                                int num,
                                                int index,
                                                int count){
        if (index == nums.length) return;
        for (int i = index; i<nums.length; i++){
            if (nums[i]>=num){
                String str = stringBuilder.append(nums[i]).toString();
                if (!set.contains(str)){
                    set.add(str);
                    temp[count] = nums[i];
                    result.add(IntStream.of(temp).limit(count+1).collect(ArrayList::new, (arr, a)-> arr.add(a), (arr1, arr2)->arr1.addAll(arr2)));
                    findSubsequences(nums, nums[i], i+1, count+1);
                }
                stringBuilder.deleteCharAt(stringBuilder.length()-1);
            }else continue;
        }
        return ;
    }
    //入参1. 原始数组，已组成的数字，当前的序号,当前的字符串，去重集合。结果集合
}
