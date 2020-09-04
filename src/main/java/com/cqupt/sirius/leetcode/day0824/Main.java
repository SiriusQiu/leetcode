package com.cqupt.sirius.leetcode.day0824;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int n = scanner.nextInt();
        String[] strs = new String[n];
        int[][] ints = new int[n][2];
        for (int i = 0; i < n; i++){
            strs[i] = scanner.next();
            ints[i][0] = scanner.nextInt();
            ints[i][1] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++){
            int count = 0;
            long result = 0;
            for (int j = 0; j < strs[i].length(); j++){
                char c = strs[i].charAt(j);
                if (c<65){
                    result = result*36 + c - '0';
                }else {
                    result = result*36 + c - 'A';
                }
            }
            System.out.println(result);
        }
    }
}
