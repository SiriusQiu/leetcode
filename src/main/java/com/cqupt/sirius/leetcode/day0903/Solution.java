package com.cqupt.sirius.leetcode.day0903;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int n = scanner.nextInt();
        int count5 = 0;
        int count0 =0;
        for (int i = 0; i < n; i++){
            int num = scanner.nextInt();
            if (num==0) count0++;
            else if (num==5) count5++;
            else throw new IllegalArgumentException();
        }
        if (count0==0) System.out.println(-1);
        StringBuilder stringBuilder = new StringBuilder();
        while (count5>=9){
            stringBuilder.append("555555555");
            count5-=9;
        }
        while (count0>0){
            stringBuilder.append(0);
            if (stringBuilder.length()==1) break;
            count0--;
        }
        System.out.println(stringBuilder.toString());
    }
}
