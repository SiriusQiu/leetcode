package com.cqupt.sirius.leetcode.day0821;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int n = scanner.nextInt();
        if (n < 220) System.out.println(0);
        int a = n/200;
        int remain = n - a * 200;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            int b = remain - i*12;
            if (b%10!=0) continue;
            b/=10;
            if (b < 10&&b >= 0&&b!=i&&b!=a&&i!=a){
                list.add(new int[]{a*100+b*10+i,a*100+i*11});
            }
        }
        list.sort((i1, i2)->i1[0]-i2[0]);
        System.out.println(list.size());
        if (list.size()>0) list.forEach(Main::print);
    }
    public static void print(int[] arr){
        System.out.println(arr[0] + " " + arr[1]);
    }
}
