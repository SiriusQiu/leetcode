package com.cqupt.sirius.leetcode.day0903;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][][] dp = new int[n][m][m];

        int count = 0;
        System.out.println(go(n, m, 0, -1, -1));
    }
    public static int go(int n, int m, int count, int first, int second){
        if (count>n) return 0;
        if (count==n) return 1;
        int result = 0;
        for (int i = 1; i <= m; i++){
            if (i==first||i==second) continue;
            int temp = 0;
            if (first==-1){
                temp = go(n, m, count+i, i, -1);

            }else temp = go(n, m, count+i, i, first);
            if (temp ==0) break;
            else  result += temp;
            result %= 100000007;
        }
        return result;
    }
}
