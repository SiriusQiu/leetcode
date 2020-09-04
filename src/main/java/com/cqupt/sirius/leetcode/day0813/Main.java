package com.cqupt.sirius.leetcode.day0813;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        URL url = Main.class.getClassLoader().getResource("input");
        int n,vMax;
        int[] volumns, weights, counts;
        try(FileInputStream fileInputStream = new FileInputStream(url.getFile());
                Scanner scanner = new Scanner(new BufferedInputStream(fileInputStream))){
            n = scanner.nextInt();
            vMax = scanner.nextInt();
            volumns = new int[n];
            weights = new int[n];
            counts = new int[n];
            for (int i = 0; i< n; i++){
                volumns[i] = scanner.nextInt();
                weights[i] = scanner.nextInt();
                counts[i] = scanner.nextInt();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        int[][] dp = new int[n][vMax+1];
        System.out.println(maxValue(volumns,weights,counts,n-1, vMax, dp));

    }

    private static int maxValue(int[] volumns, int[] weights,int[] counts, int i, int j, int[][] dp){
        if (i<0||j<=0) return 0;
        if (dp[i][j] > 0) return dp[i][j];
        if (i==0){
            if (volumns[0]<=j){
                int result = 0;
                int remain = j;
                while (remain>=0){
                    result += weights[0];
                    remain -= volumns[0];
                }
                dp[0][j] = result - weights[0];
                return dp[0][j];
            }else return 0;
        }
        int result = 0;
        for (int k = 0; j-k*volumns[i] >=0&&k <= counts[i]; k++){
            int max = maxValue(volumns,weights,counts, i-1, j-k*volumns[i],dp) + weights[i]*k;
            result = result>max?result:max;
        }
        dp[i][j] = result;

        return result;
    }


}
