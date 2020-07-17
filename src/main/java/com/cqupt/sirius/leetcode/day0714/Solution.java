package com.cqupt.sirius.leetcode.day0714;

public class Solution {
    private static int quickSearchK(int[] arr, int l, int r, int index) {
        if (l >= r) return arr[l];
        int i = l - 1;
        int j = r + 1;
        int x = arr[l];
        while (i < j){
            while (arr[++i]<x);
            while (arr[--j]>x);
            if (i < j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        if (j >= index){
            return quickSearchK(arr, l, j, index);
        }else {
            return quickSearchK(arr, j+1, r, index);
        }
    }
}
