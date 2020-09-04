package com.cqupt.sirius.leetcode.day0829;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int n = scanner.nextInt();
        StringBuilder stringBuilder = new StringBuilder();
        int[][] arr = new int[n+1][n+1];
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= n; j++){
                arr[i][j] = scanner.nextInt();
            }
        }
        boolean[] flag = new boolean[n+1];
        int[] result = new int[n+1];
        for (int i = 1; i<= n; i++){
            for (int j = 1; j <= n; j++){
                if (!flag[arr[i][j]]){
                    result[i] = arr[i][j];
                    flag[arr[i][j]] = true;
                    break;
                }
            }
        }
        for (int i = 1; i <= n; i++){
            System.out.print(result[i] + " ");
        }
    }
}
