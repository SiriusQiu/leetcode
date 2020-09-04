package com.cqupt.sirius.leetcode.day0904.kmp;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int n = scanner.nextInt();
        String p = scanner.next();
        int m = scanner.nextInt();
        String s = scanner.next();
        //next指的是，到当前序号中，最长前缀的序号
        int[] next = new int[n];
        next[0] = -1;
        for (int i = 1, j = -1; i < n; i++){
            while (j!=-1&&p.charAt(i)!=p.charAt(j+1)) j = next[j];
            if (p.charAt(i) == p.charAt(j+1)) j++;
            next[i] = j;
        }
        for (int i = 0, j = -1; i < m; i++){
            while (j!=-1&& s.charAt(i)!=p.charAt(j+1)) j = next[j];
            if (s.charAt(i) == p.charAt(j+1)) j++;
            if (j==n-1){
                System.out.println(i-j);
                break;
            }
        }
    }
}
