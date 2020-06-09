package com.cqupt.sirius.leetcode.day0530;

public class Solution {
    public int[] quickSort(int[] array){
        return array;
    }
    public int[] quickSort(int[] array, int left, int right){
        if (left >= right) return array;
        int i = left;
        int j = right;
        int x = array[left];
        while (i<j){
            while (array[i]<x) i++;
            while (array[j]>x) j--;
        }
        swap(array, i, j);
        return array;
    }
    public void swap(int[] array, int x, int y){
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
}
