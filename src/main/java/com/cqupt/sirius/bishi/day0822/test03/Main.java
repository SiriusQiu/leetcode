package com.cqupt.sirius.bishi.day0822.test03;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int n = scanner.nextInt();
        int[] ws = new int[n];
        for (int i = 0; i < n; i++){
            ws[i] = scanner.nextInt();
        }
        int[] ps = new int[n];
        for (int i = 0; i < n; i++){
            ps[i] = scanner.nextInt();
        }
        int[] sums = new int[n+1];
        for (int i = 1; i < n+1; i++){
            sums[i] = sums[i-1] + ws[i-1];
        }
        boolean[] flags = new boolean[n];
        int max = sums[n] - sums[0];
        for (int i =0; i<n; i++){
            int index = ps[i];
            int leftindex=index-1;
            int rightindex = index-1;
            while (!flags[--leftindex]);
            while (!flags[++rightindex]);
            int leftsum = sums[index-1] - sums[leftindex+1];
            int rightsum = sums[rightindex] - sums[index];
            max = leftsum>rightsum?leftsum:rightsum;
            flags[index-1] = true;
            System.out.println(max);
        }
    }
}
