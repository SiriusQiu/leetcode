package com.cqupt.sirius.leetcode.day0812;

import java.util.*;
import java.util.stream.IntStream;

public class Solution {
    public int reversePairs(int[] nums) {
        if (nums==null||nums.length <=1) return 0;
        int[] temp = new int[nums.length];
        return reversePairs(nums,0, nums.length-1, temp);
    }
    public int reversePairs(int[] nums, int left, int right, int[] temp) {
        if (left >= right) return 0;
        int mid = left + (right - left)/2;
        int result = 0;
        result += reversePairs(nums, left, mid, temp);
        result += reversePairs(nums, mid+1, right, temp);
        tag:
        for (int i = left; i <=mid; i++){
            for (int j = mid+1;i <=mid&&j <= right; j++ ){
                if (nums[i]>nums[j]&&j==right){
                    result += (mid - i + 1)*(right-mid);
                    break  tag;
                }
                else if (nums[i]<=nums[j]){
                    j--;
                    result += (j - mid)>=0?j - mid:0;
                    i++;
                }
            }
        }
        int i = left;
        int j = mid+1;
        int index = left;
        while (i <= mid&&j<=right){
            if (nums[i]<nums[j]) temp[index] = nums[i++];
            else temp[index] = nums[j++];
            index++;
        }
        while (i<=mid) temp[index++] = nums[i++];
        while (j<=right) temp[index++] = nums[j++];
        index = left;
        while (index <= right) nums[index] = temp[index++];
        return result;
    }

    public String[] permutation(String s) {
        if (s ==null || s.length()==0) return new String[]{};
        if (s.length() == 1) return new String[]{s};
        StringBuilder stringBuilder = new StringBuilder();
        List<String> list = new ArrayList<>();
        boolean[] flag  = new boolean[s.length()];
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (map.containsKey(c)){
                int count =  map.get(c)+1;
                map.put(c, count);
            }else map.put(c, 1);
        }
        permutation(s, map, stringBuilder, list);
        Object[] result = list.stream().toArray();
        return  Arrays.copyOf(result, result.length, String[].class);
    }

    public void permutation(String s, Map<Character, Integer> map, StringBuilder stringBuilder, List<String> list){
        if (stringBuilder.length() == s.length()) {
            list.add(stringBuilder.toString());
            return;
        }
        Set<Map.Entry<Character, Integer>> set = map.entrySet();
        Iterator<Map.Entry<Character, Integer>> iterator = set.iterator();
        while (iterator.hasNext()){
            Map.Entry<Character, Integer> entry = iterator.next();
            char c = entry.getKey();
            int value = entry.getValue();
            if (value > 0){
                entry.setValue(value - 1);
                stringBuilder.append(c);
                permutation(s, map, stringBuilder, list);
                entry.setValue(value);
                stringBuilder.deleteCharAt(stringBuilder.length()-1);
            }
        }
    }


    public static void main(String[] args) {
        String s = "abc";
        Solution solution = new Solution();
        Arrays.stream(solution.permutation(s)).forEach(System.out::println);
    }
    public static void printInt(int i){
        System.out.print(i + " ");
    }




}
