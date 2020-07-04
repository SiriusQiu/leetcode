package com.cqupt.sirius.leetcode.day0612;

import java.util.Arrays;

public class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] result = new int[k];
        if (k == 0) return result;
        int count = 0;
        for (int num : arr){
            if(count < k){
                int i = count;
                while (i>0&&num<result[i-1]){
                    result[i] = result[i-1];
                    i--;
                }
                result[i] = num;
                count++;
            }else if (count == k){
                int i = count;
                while (i>0&&num<result[i-1]){
                    if (i<count) result[i] = result[i-1];
                    i--;
                }
                if (i == count) i--;
                if (num < result[i]) result[i] = num;
            }else {
                throw new IllegalArgumentException();
            }
        }
        return result;
    }

    public int lastRemaining(int n, int m) {
        if (n == 1) return 0;
        int last = lastRemaining(n-1, m);
        int result = (last+m)%n;
        return result;
    }

    public int massage(int[] nums) {
        if (nums.length == 0) return 0;
        int[] array1 = new int[nums.length];
        int[] array2 = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            if (i == 0){
                array1[i] = 0;
                array2[i] = nums[i];
                continue;
            }
            array1[i] = array1[i-1] > array2[i-1]? array1[i-1]:array2[i-1];
            array2[i] = array1[i-1] + nums[i];
        }
        int length = nums.length;
        return array1[length-1] > array2[length-1]? array1[length-1]: array2[length-1];
    }
    public void maxMassage(int[] array1, int[] array2, int nums, int k){

    }



}
