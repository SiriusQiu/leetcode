package com.cqupt.sirius.leetcode.day0822;

import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        IntStream.of(arr).forEach(Main::print);
    }
    public static void print(int num){
        int result = 0;
        while (num >0){
            num -= num&(-num);
            result++;
        }
        System.out.print( result + " ");
    }


}
