package com.cqupt.sirius.leetcode.day0531;

import java.util.Arrays;
import java.util.Random;

public class Solution {

    public int[] quickSort(int[] array){
        quickSort(array, 0, array.length-1);
        return array;
    }
    public int[] quickSort(int[] array, int left, int right){
        if (left >= right) return array;
        int i = left-1;
        int j = right+1;
        int x = array[left];
        while (i<j){
            do i++; while (array[i]<x);
            do j--; while (array[j]>x);
            if (i < j) swap(array, i, j);
        }
        quickSort(array,left,j);
        quickSort(array,j+1, right);
        return array;
    }
    public void swap(int[] array, int x, int y){
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int length = random.nextInt(10)+10;
        int[] array = new int[length];
        for (int i = 0; i < length; i++){
            array[i] = random.nextInt(100);
        }
        array=new int[]{2, 2, 12, 48, 53, 32, 56, 56, 25, 83, 92, 86, 92, 68, 59};
        //array=new int[]{81, 31, 79, 60, 59};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(array));
        solution.quickSort(array);
        System.out.println(Arrays.toString(array));
    }
}
