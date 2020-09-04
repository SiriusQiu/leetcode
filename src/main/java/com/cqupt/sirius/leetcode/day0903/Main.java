package com.cqupt.sirius.leetcode.day0903;

import java.io.BufferedInputStream;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int T = scanner.nextInt();
        Set<Integer> set1 = new HashSet<>();
        final Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < T; i++){
            int n = scanner.nextInt();
            set1.clear();
            int m = scanner.nextInt();
            for (int j = 0; j < m;j++){
                set2.clear();
                int k = scanner.nextInt();
                for (int p = 0; p < k; p++){
                    int l = scanner.nextInt();
                    int r = scanner.nextInt();
                    for (int q = l; q <= r; q++){
                        set2.add(q);
                    }
                }
                if (set1.isEmpty()){
                    set1.addAll(set2);
                }else {
                    set1.removeIf(integer->!set2.contains(integer));
                }
            }
            System.out.println(set1.size());
            set1.stream().sorted().forEach(Main::print);
            System.out.println();
        }
    }
    public static void print(int num){
        System.out.print(num + " ");
    }
}
