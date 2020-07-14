package com.cqupt.sirius.leetcode.day0531;

import java.util.HashMap;
import java.util.Scanner;
import java.io.BufferedInputStream;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        quickSearchK(arr, 0, n - 1,0);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static int quickSearchK(int[] arr, int left, int right, int k){
        if (left >= right) return arr[left];
        int i = left - 1;
        int j = right + 1;
        int x = arr[left + right >> 1];
        while (i < j){
            while (arr[++i] < x);
            while (arr[--j] > x);
            if(i<j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        if (j - left + 1 >= k) return quickSearchK(arr, left, j, k);
        else return quickSearchK(arr, j + 1, right, k - (j - left + 1));
    }

}
